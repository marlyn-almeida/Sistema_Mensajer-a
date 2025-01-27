import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function RoomCreate() {
    const [roomName, setRoomName] = useState('');
    const navigate = useNavigate();

    const handleCreateRoom = () => {
        if (roomName) {
            // Aquí iría la lógica para crear la sala
            navigate(`/chat/${roomName}`);
        } else {
            alert("Por favor ingresa un nombre para la sala");
        }
    };

    return (
        <div className="create-room-container">
            <h1>Crear Nueva Sala</h1>
            <input
                type="text"
                placeholder="Nombre de la sala"
                value={roomName}
                onChange={(e) => setRoomName(e.target.value)}
            />
            <button onClick={handleCreateRoom}>Crear Sala</button>
        </div>
    );
}

export default RoomCreate;
