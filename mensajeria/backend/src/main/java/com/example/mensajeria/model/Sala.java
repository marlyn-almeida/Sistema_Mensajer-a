package com.example.mensajeria.model;

import com.example.mensajeria.websocket.ChatMessage;  // Correcto import

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "salas")
public class Sala {

    @Id
    private String id;  // ID de la sala
    private String nombre;  // Nombre de la sala
    private List<String> participantes;  // Lista de ID de usuarios que participan
    private List<ChatMessage> mensajes;  // Lista de mensajes enviados en la sala

    // Constructor
    public Sala(String nombre, List<String> participantes, List<ChatMessage> mensajes) {
        this.nombre = nombre;
        this.participantes = participantes;
        this.mensajes = mensajes;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public List<ChatMessage> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<ChatMessage> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", participantes=" + participantes +
                ", mensajes=" + mensajes +
                '}';
    }
}
