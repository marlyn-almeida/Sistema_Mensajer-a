package com.example.mensajeria.controller;

import com.example.mensajeria.model.Mensaje;
import com.example.mensajeria.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private MensajeRepository mensajeRepository;

    // Obtener todos los mensajes
    @GetMapping
    public List<Mensaje> getAllMensajes() {
        return mensajeRepository.findAll();
    }

    // Enviar un mensaje
    @PostMapping
    public Mensaje createMensaje(@RequestBody Mensaje mensaje) {
        // Configura la fecha y hora de envío antes de guardar
        mensaje.setFechaEnvio(java.time.LocalDateTime.now());
        return mensajeRepository.save(mensaje);
    }
}
