package com.example.mensajeria.model;

public class Mensaje {

    private String contenido;
    private String usuario;

    public Mensaje(String contenido, String usuario) {
        this.contenido = contenido;
        this.usuario = usuario;
    }

    // Getters y setters
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
}
