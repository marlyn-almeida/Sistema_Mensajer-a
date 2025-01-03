package com.example.mensajeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mensajeria.model.Mensaje;
import com.example.mensajeria.repository.MensajeRepository;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    // Guardar el mensaje en la base de datos
    public void saveMensaje(Mensaje mensaje) {
        mensajeRepository.save(mensaje);
    }
}
