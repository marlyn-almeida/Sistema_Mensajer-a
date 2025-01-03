package com.example.mensajeria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.mensajeria.model.Mensaje;

public interface MensajeRepository extends MongoRepository<Mensaje, String> {
}
