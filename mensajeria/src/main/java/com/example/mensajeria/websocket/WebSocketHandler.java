package com.example.mensajeria.websocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;

@Component
public class WebSocketHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) {
        // Lógica para manejar los mensajes WebSocket
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(message);
        String username = (String) headerAccessor.getHeader("simpUser");
        // Aquí puedes agregar la lógica para manejar los mensajes
        System.out.println("Nuevo mensaje recibido de " + username);
    }
}
