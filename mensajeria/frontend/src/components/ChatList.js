import React from 'react';
import { useNavigate } from 'react-router-dom';

function ChatList() {
    const navigate = useNavigate();

    const joinRoom = (roomId) => {
        navigate(`/chat/${roomId}`);
    };

    return (
        <div className="chat-list-container">
            <h1>Salas de Chat</h1>
            <button onClick={() => navigate('/create-room')}>Crear Nueva Sala</button>
            <div className="room-list">
                <div className="room" onClick={() => joinRoom(1)}>Sala General</div>
                <div className="room" onClick={() => joinRoom(2)}>Sala de Programadores</div>
            </div>
        </div>
    );
}

export default ChatList;
