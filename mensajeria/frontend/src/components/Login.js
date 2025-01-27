import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Para redirigir después de login o registro
import './Login.css';

function Login({ onRegister }) {
    const [nombre, setNombre] = useState('');
    const [username, setUsername] = useState('');
    const [isLogin, setIsLogin] = useState(true); // Para saber si mostrar el formulario de login o registro
    const navigate = useNavigate(); // Hook para navegación

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!username) {
            alert("Por favor, ingrese su nombre de usuario.");
            return;
        }

        const usuario = { nombre, username };

        try {
            const endpoint = isLogin ? '/api/usuarios/login' : '/api/usuarios/register';
            const response = await fetch(`http://localhost:8080${endpoint}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(usuario),
            });

            if (response.ok) {
                const data = await response.json();
                onRegister(data.username); // Actualiza el estado del usuario en la App
                navigate('/salas'); // Redirige a las salas
            } else if (response.status === 400) {
                alert("Usuario no encontrado o datos inválidos.");
            } else {
                alert("Error en la comunicación con el servidor.");
            }
        } catch (error) {
            console.error("Error al hacer la solicitud:", error);
            alert("Error en la comunicación con el servidor.");
        }
    };

    return (
        <div className="login-container">
            <h1>{isLogin ? "Iniciar Sesión" : "Registrarse"}</h1>

            {/* Formulario de Login */}
            {isLogin ? (
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <button type="submit">Iniciar sesión</button>
                    <p>
                        ¿No tienes cuenta?{' '}
                        <span onClick={() => setIsLogin(false)} style={{ cursor: 'pointer', color: 'blue' }}>
                            Regístrate aquí
                        </span>
                    </p>
                </form>
            ) : (
                // Formulario de Registro
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        placeholder="Nombre "
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
                    <p>
                        ¿Ya tienes cuenta?{' '}
                        <span onClick={() => setIsLogin(true)} style={{ cursor: 'pointer', color: 'blue' }}>
                            Inicia sesión aquí
                        </span>
                    </p>
                </form>
            )}
        </div>
    );
}

export default Login;
