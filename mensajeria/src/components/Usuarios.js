import React, { useEffect, useState } from "react";
import api from "../axiosConfig"; // Este archivo centraliza las solicitudes HTTP

const Usuarios = () => {
    const [usuarios, setUsuarios] = useState([]); // Estado para los usuarios
    const [nuevoUsuario, setNuevoUsuario] = useState({
        nombre: "",
        username: "",
    });

    // Función para obtener usuarios de la API
    useEffect(() => {
        const fetchUsuarios = async () => {
            try {
                const response = await api.get("/usuarios");
                setUsuarios(response.data); // Guardar usuarios en el estado
            } catch (error) {
                console.error("Error al obtener usuarios:", error);
            }
        };

        fetchUsuarios();
    }, []);

    // Manejar cambios en el formulario
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNuevoUsuario({ ...nuevoUsuario, [name]: value });
    };

    // Guardar un nuevo usuario
    const handleFormSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await api.post("/usuarios", nuevoUsuario);
            setUsuarios([...usuarios, response.data]); // Actualiza la lista de usuarios
            setNuevoUsuario({ nombre: "", username: "" }); // Limpia el formulario
        } catch (error) {
            console.error("Error al guardar usuario:", error);
        }
    };

    return (
        <div>
            <h1>Usuarios</h1>

            {/* Formulario para agregar usuarios */}
            <form onSubmit={handleFormSubmit}>
                <input
                    type="text"
                    name="nombre"
                    placeholder="Nombre"
                    value={nuevoUsuario.nombre}
                    onChange={handleInputChange}
                    required
                />
                <input
                    type="text"
                    name="username"
                    placeholder="Nombre de usuario"
                    value={nuevoUsuario.username}
                    onChange={handleInputChange}
                    required
                />
                <button type="submit">Agregar Usuario</button>
            </form>

            {/* Lista de usuarios */}
            <ul>
                {usuarios.map((usuario) => (
                    <li key={usuario.id}>
                        <strong>{usuario.nombre}</strong> - @{usuario.username}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Usuarios;
