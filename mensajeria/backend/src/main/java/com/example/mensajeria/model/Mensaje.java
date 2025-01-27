package com.example.mensajeria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "mensajes")
public class Mensaje {

    @Id
    private String id;
    private String contenido;
    private String usuario;
    private LocalDateTime fechaEnvio; // Campo para la fecha y hora

    public Mensaje() {}

    public Mensaje(String contenido, String usuario) {
        this.contenido = contenido;
        this.usuario = usuario;
        this.fechaEnvio = LocalDateTime.now(); // Fecha y hora actuales
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
