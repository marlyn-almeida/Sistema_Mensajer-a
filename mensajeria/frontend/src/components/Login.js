import React, { useState } from 'react';
import './Login.css';
import { useNavigate } from 'react-router-dom';


function Login({ onRegister }) {
    const [nombre, setNombre] = useState('');
    const [username, setUsername] = useState('');
    const navigate = useNavigate(); // Redirección

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!nombre || !username) {
            alert("Por favor, complete ambos campos.");
            return;
        }

        const usuario = { nombre, username };

        try {
            const response = await fetch('http://localhost:8080/api/usuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(usuario),
            });

            if (response.ok) {
                const data = await response.json();
                onRegister(data.username);  // Pasa el nombre de usuario al padre (App)
                alert("Usuario registrado exitosamente");
                navigate("/salas"); // Redirige a la pantalla de salas
            } else {
                alert("Error al registrar el usuario");
            }
        } catch (error) {
            console.error("Error al hacer la solicitud:", error);
            alert("Error en la comunicación con el servidor.");
        }
    };

    return (
        <div className="login-container">
            <h1>Registrarse</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Nombre"
                    value={nombre}
                    onChange={(e) => setNombre(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Nombre de usuario"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <button type="submit">Registrarse</button>
            </form>
        </div>
    );
}

export default Login;