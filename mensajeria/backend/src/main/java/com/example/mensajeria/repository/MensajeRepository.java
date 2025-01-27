package com.example.mensajeria.repository;

import com.example.mensajeria.model.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MensajeRepository extends MongoRepository<Mensaje, String> {
}
