import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Usuarios from "./components/Usuarios"; // Aquí importas tu componente Usuarios

const App = () => {
    return (
        <Router>
            <header>
                <nav>
                    <ul>
                        <li>
                            <Link to="/usuarios">Usuarios</Link> {/* Enlace a Usuarios */}
                        </li>
                        <li>
                            <Link to="/mensajes">Mensajes</Link> {/* (Si tienes un componente para mensajes) */}
                        </li>
                    </ul>
                </nav>
            </header>

            <Routes>
                <Route path="/usuarios" element={<Usuarios />} /> {/* Ruta para Usuarios */}
                {/* Si tienes más componentes, puedes agregar más rutas aquí */}
            </Routes>
        </Router>
    );
};

export default App;
