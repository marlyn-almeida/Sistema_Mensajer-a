package com.example.mensajeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.example.mensajeria.model.Mensaje;
import com.example.mensajeria.service.MensajeService;

@Controller
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    // Recibe un mensaje del cliente y lo reenvía a todos los clientes suscritos
    @MessageMapping("/send") // Se invoca cuando el cliente envía un mensaje
    @SendTo("/topic/messages") // Todos los clientes suscritos recibirán el mensaje
    public Mensaje sendMessage(Mensaje mensaje) {
        // Aquí puedes guardar el mensaje en la base de datos si es necesario
        mensajeService.saveMensaje(mensaje);
        return mensaje;
    }
}
