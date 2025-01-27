package com.example.mensajeria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "usuarios") // Define la colección en MongoDB
public class Usuario {

    @Id
    private String id;
    @NotNull
    private String nombre;
    private String username;

    public Usuario() {}

    public Usuario(String nombre, String username) {
        this.nombre = nombre;
        this.username = username;
    }

    // Getters y setters
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
