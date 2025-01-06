package com.example.mensajeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mensajeria.model.Mensaje;
import com.example.mensajeria.repository.MensajeRepository;

import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    // Guarda un mensaje en la base de datos
    public Mensaje saveMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    // Obtiene todos los mensajes
    public List<Mensaje> getAllMensajes() {
        return mensajeRepository.findAll();
    }
}
