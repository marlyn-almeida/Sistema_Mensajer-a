import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/">Login</Link></li>
                <li><Link to="/seleccionar-opcion">Seleccionar Sala</Link></li>
                <li><Link to="/chat">Chat</Link></li>
            </ul>
        </nav>
    );
};

export default Navbar;
