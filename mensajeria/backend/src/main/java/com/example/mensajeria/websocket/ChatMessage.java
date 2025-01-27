package com.example.mensajeria.websocket;

import java.time.LocalDateTime;

public class ChatMessage {
    private String type; // Tipo de mensaje (newUser, leave, etc.)
    private String username; // Nombre de usuario que envía el mensaje
    private String salaId; // Sala a la que pertenece el mensaje
    private String content; // Contenido del mensaje
    private LocalDateTime timestamp; // Marca de tiempo del mensaje

    // Getters y setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
