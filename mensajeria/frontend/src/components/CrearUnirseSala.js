// src/components/CrearUnirseSala.js
import React, { useState } from 'react';

const CrearUnirseSala = ({ username }) => {
    const [room, setRoom] = useState('');

    const handleCreateRoom = () => {
        console.log(`${username} ha creado la sala: ${room}`);
    };

    const handleJoinRoom = () => {
        console.log(`${username} se unió a la sala: ${room}`);
    };

    return (
        <div>
            <h1>Bienvenido, {username}</h1>
            <input
                type="text"
                placeholder="Nombre de la sala"
                value={room}
                onChange={(e) => setRoom(e.target.value)}
            />
            <button onClick={handleCreateRoom}>Crear Sala</button>
            <button onClick={handleJoinRoom}>Unirse a Sala</button>
        </div>
    );
};

export default CrearUnirseSala;
