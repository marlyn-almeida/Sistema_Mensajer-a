// src/components/Chat.js
import React from 'react';

const Chat = ({ username }) => {
    return (
        <div>
            <h1>Chat</h1>
            <p>Bienvenido, {username}. ¡Aquí puedes chatear con otros usuarios!</p>
            {/* Agrega aquí el código de la sala de chat */}
        </div>
    );
};

export default Chat;
