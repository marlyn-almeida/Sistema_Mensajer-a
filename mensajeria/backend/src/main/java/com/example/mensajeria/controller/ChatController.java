package com.example.mensajeria.controller;

import com.example.mensajeria.model.Mensaje;
import com.example.mensajeria.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private MensajeRepository mensajeRepository;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Mensaje enviarMensaje(Mensaje mensaje) {
        mensajeRepository.save(mensaje); // Guarda el mensaje en la base de datos
        return mensaje;
    }
}
