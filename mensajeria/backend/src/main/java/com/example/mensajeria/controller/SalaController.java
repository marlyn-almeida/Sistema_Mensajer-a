package com.example.mensajeria.controller;

import com.example.mensajeria.model.Sala;
import com.example.mensajeria.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    // Crear una nueva sala
    @PostMapping
    public ResponseEntity<Sala> crearSala(@RequestBody Sala sala) {
        // Verificar si la sala ya existe por su nombre
        if (salaRepository.findByNombre(sala.getNombre()) != null) {
            return ResponseEntity.badRequest().body(null); // La sala ya existe
        }
        // Guardar la nueva sala
        Sala nuevaSala = salaRepository.save(sala);
        return ResponseEntity.ok(nuevaSala);
    }

    // Unirse a una sala existente
    @PostMapping("/{id}/unirse")
    public ResponseEntity<Sala> unirseSala(@PathVariable String id, @RequestBody String userId) {
        Optional<Sala> salaOpt = salaRepository.findById(id);
        if (salaOpt.isPresent()) {
            Sala sala = salaOpt.get();
            // Agregar el ID del usuario a la lista de participantes
            sala.getParticipantes().add(userId);
            salaRepository.save(sala); // Guardar la sala actualizada
            return ResponseEntity.ok(sala);
        }
        return ResponseEntity.notFound().build(); // Si la sala no existe
    }

    // Obtener todas las salas
    @GetMapping
    public ResponseEntity<?> listarSalas() {
        return ResponseEntity.ok(salaRepository.findAll()); // Retornar la lista de salas
    }

    // Obtener una sala por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerSala(@PathVariable String id) {
        Optional<Sala> salaOpt = salaRepository.findById(id);
        if (salaOpt.isPresent()) {
            return ResponseEntity.ok(salaOpt.get());
        }
        return ResponseEntity.notFound().build(); // Si no se encuentra la sala
    }
}
