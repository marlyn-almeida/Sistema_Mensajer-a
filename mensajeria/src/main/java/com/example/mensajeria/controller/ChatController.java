package com.example.mensajeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    // Maneja la ruta raíz
    @GetMapping("/")
    public String home() {
        return "index"; // Retorna la vista llamada 'index.html'
    }

    // Agrega otros mapeos si necesitas más páginas
}
