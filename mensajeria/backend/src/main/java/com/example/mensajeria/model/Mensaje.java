package com.example.mensajeria.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Mensaje {
    @Id
    private String id;
    private String salaId; // Sala a la que pertenece el mensaje
    private String username; // Usuario que envió el mensaje
    private String contenido; // Contenido del mensaje
    private LocalDateTime timestamp; // Marca de tiempo del mensaje

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
