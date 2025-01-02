package com.example.real_time_chat;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@SpringBootApplication
public class RealTimeChatApplication extends TextWebSocketHandler { // Se extiende TextWebSocketHandler

    public static void main(String[] args) {
        SpringApplication.run(RealTimeChatApplication.class, args);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        // Manejar el mensaje recibido y enviar la respuesta
        String payload = message.getPayload();
        TextMessage responseMessage = new TextMessage("Mensaje recibido: " + payload);
        session.sendMessage(responseMessage);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("Nuevo cliente conectado: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("Cliente desconectado: " + session.getId());
    }
}
