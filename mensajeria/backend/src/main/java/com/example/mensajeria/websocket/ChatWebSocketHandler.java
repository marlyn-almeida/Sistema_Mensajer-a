package com.example.mensajeria.websocket;

import com.example.mensajeria.model.Mensaje;
import com.example.mensajeria.repository.MensajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sessions = new ArrayList<>();
    private static final List<String> users = new ArrayList<>();
    private static final List<String> activeRooms = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MensajeRepository mensajeRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        ChatMessage chatMessage = parseMessage(payload);

        if ("newUser".equals(chatMessage.getType())) {
            users.add(chatMessage.getUsername());
        } else if ("leave".equals(chatMessage.getType())) {
            users.remove(chatMessage.getUsername());
        }

        // Aquí agregamos el manejo de las salas
        String salaId = chatMessage.getSalaId();
        if (salaId != null && !salaId.isEmpty()) {
            if (!activeRooms.contains(salaId)) {
                activeRooms.add(salaId);
            }
        }

        // Guardar mensaje en la base de datos
        saveMessageToDatabase(chatMessage);

        // Broadcast de la lista de usuarios
        broadcastUsers();

        // Broadcast del mensaje
        broadcastMessage(chatMessage);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        broadcastUsers();
    }

    private void saveMessageToDatabase(ChatMessage chatMessage) {
        Mensaje mensaje = new Mensaje();
        mensaje.setSalaId(chatMessage.getSalaId());
        mensaje.setUsername(chatMessage.getUsername());
        mensaje.setContenido(chatMessage.getContent());
        mensaje.setTimestamp(chatMessage.getTimestamp());

        mensajeRepository.save(mensaje);
    }

    private void broadcastMessage(ChatMessage chatMessage) throws IOException {
        for (WebSocketSession session : sessions) {
            session.sendMessage(new TextMessage(chatMessage.toString()));
        }
    }

    private void broadcastUsers() throws IOException {
        String usersJson = "{\"type\":\"userList\",\"users\":" + users + "}";
        for (WebSocketSession session : sessions) {
            session.sendMessage(new TextMessage(usersJson));
        }
    }

    private ChatMessage parseMessage(String payload) throws IOException {
        return objectMapper.readValue(payload, ChatMessage.class);
    }
}
