package com.example.mensajeria.repository;

import com.example.mensajeria.model.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalaRepository extends MongoRepository<Sala, String> {
    Sala findByNombre(String nombre);
}
