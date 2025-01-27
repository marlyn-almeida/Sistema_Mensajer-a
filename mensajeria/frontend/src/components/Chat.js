import React, { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import './Chat.css';

function Chat() {
    const [messages, setMessages] = useState([]);
    const [message, setMessage] = useState('');
    const [users, setUsers] = useState([]);
    const [username, setUsername] = useState(''); // Deberías pasar el username como prop o obtenerlo del login
    const socketRef = useRef(null); // Referencia al WebSocket
    const navigate = useNavigate();

    // Al cargar el componente, conectar al WebSocket
    useEffect(() => {
        socketRef.current = new WebSocket('ws://localhost:8080/chat'); // URL de WebSocket
        socketRef.current.onopen = () => {
            console.log('Conectado al servidor');
            // Enviar el nombre de usuario al conectar (opcional)
            socketRef.current.send(JSON.stringify({ type: 'newUser', username }));
        };

        // Recibir mensajes y actualizaciones de usuarios
        socketRef.current.onmessage = (event) => {
            const data = JSON.parse(event.data);

            // Si el tipo es 'message', agregar el mensaje a la lista
            if (data.type === 'message') {
                setMessages((prevMessages) => [...prevMessages, data]);
            }

            // Si el tipo es 'userList', actualizar la lista de usuarios conectados
            if (data.type === 'userList') {
                setUsers(data.users);
            }
        };

        return () => {
            socketRef.current.close(); // Cerrar WebSocket cuando el componente se desmonte
        };
    }, [username]);

    // Enviar un mensaje
    const sendMessage = () => {
        if (message.trim()) {
            const messageData = {
                type: 'message',
                username,
                content: message,
                timestamp: new Date().toLocaleTimeString(),
            };
            socketRef.current.send(JSON.stringify(messageData)); // Enviar el mensaje al servidor
            setMessage('');
        }
    };

    // Manejar el envío al presionar "Enter"
    const handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            sendMessage();
        }
    };

    // Salir de la sala de chat
    const leaveChat = () => {
        socketRef.current.send(JSON.stringify({ type: 'leave', username }));
        navigate('/salas'); // Redirigir a las salas
    };

    return (
        <div className="chat-container">
            <div className="chat-header">
                <button className="back-btn" onClick={leaveChat}>Salir</button>
                <h2>Chat</h2>
            </div>
            <div className="chat-users">
                <h3>Usuarios en línea</h3>
                <ul>
                    {users.map((user, index) => (
                        <li key={index}>{user}</li>
                    ))}
                </ul>
            </div>
            <div className="chat-messages">
                {messages.map((msg, index) => (
                    <div
                        key={index}
                        className={`message ${msg.username === username ? 'own' : ''}`}
                    >
                        <div className="message-header">
                            <span className="username">{msg.username}</span>
                            <span className="timestamp">{msg.timestamp}</span>
                        </div>
                        <div className="message-body">
                            <span>{msg.content}</span>
                        </div>
                    </div>
                ))}
            </div>
            <div className="chat-input">
                <input
                    type="text"
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                    onKeyPress={handleKeyPress}
                    placeholder="Escribe un mensaje..."
                />
                <button onClick={sendMessage}>Enviar</button>
            </div>
        </div>
    );
}

export default Chat;
