import React, { useState } from 'react';
import './App.css';
import Login from './components/Login';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Chat from './components/Chat';
import CrearUnirseSala from './components/CrearUnirseSala';

function App() {
    const [username, setUsername] = useState(null);

    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login onRegister={setUsername} />} />
                <Route path="/salas" element={<CrearUnirseSala />} />
                <Route path="/chat" element={<Chat />} />
                {/* otras rutas */}
            </Routes>
        </Router>
    );
}

export default App;
