import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function CrearUnirseSala() {
    const [salas, setSalas] = useState([]); // Lista de salas existentes
    const [nuevaSala, setNuevaSala] = useState(''); // Input para crear sala
    const [salaId, setSalaId] = useState(''); // Input para unirse a una sala
    const navigate = useNavigate();

    // Cargar las salas al montar el componente
    useEffect(() => {
        fetch('http://localhost:8080/api/salas') // Reemplaza con tu backend
            .then((response) => response.json())
            .then((data) => setSalas(data))
            .catch((error) => console.error('Error al obtener salas:', error));
    }, []);

    // Crear una nueva sala
    const handleCrearSala = () => {
        if (!nuevaSala.trim()) {
            alert('Por favor, ingresa un nombre para la sala.');
            return;
        }

        fetch('http://localhost:8080/api/salas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ nombre: nuevaSala }),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('No se pudo crear la sala. Intenta nuevamente.');
                }
                return response.json();
            })
            .then((salaCreada) => {
                alert(`Sala "${salaCreada.nombre}" creada exitosamente.`);
                setNuevaSala('');
                setSalas((prevSalas) => [...prevSalas, salaCreada]); // Actualizar la lista de salas
            })
            .catch((error) => console.error('Error al crear sala:', error));
    };

    // Unirse a una sala por ID
    const handleUnirseSala = () => {
        if (!salaId.trim()) {
            alert('Por favor, ingresa el ID de la sala.');
            return;
        }

        fetch(`http://localhost:8080/api/salas/${salaId}/unirse`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify('userId123'), // Sustituye por el ID real del usuario
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('No se pudo unir a la sala. Verifica el ID.');
                }
                return response.json();
            })
            .then(() => {
                alert('Te has unido a la sala.');
                navigate('/chat'); // Redirigir al chat
            })
            .catch((error) => console.error('Error al unirse a la sala:', error));
    };

    return (
        <div className="crear-unirse-sala">
            <h1>Gestión de Salas</h1>

            {/* Formulario para crear una sala */}
            <div>
                <h2>Crear Sala</h2>
                <input
                    type="text"
                    placeholder="Nombre de la nueva sala"
                    value={nuevaSala}
                    onChange={(e) => setNuevaSala(e.target.value)}
                />
                <button onClick={handleCrearSala}>Crear</button>
            </div>

            {/* Formulario para unirse a una sala */}
            <div>
                <h2>Unirse a Sala</h2>
                <input
                    type="text"
                    placeholder="ID de la sala"
                    value={salaId}
                    onChange={(e) => setSalaId(e.target.value)}
                />
                <button onClick={handleUnirseSala}>Unirse</button>
            </div>

            {/* Lista de salas disponibles */}
            <div>
                <h2>Salas Disponibles</h2>
                <ul>
                    {salas.map((sala) => (
                        <li key={sala.id}>
                            {sala.nombre} - ID: {sala.id}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default CrearUnirseSala;
