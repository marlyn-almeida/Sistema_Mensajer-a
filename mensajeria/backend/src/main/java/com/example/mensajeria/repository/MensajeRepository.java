package com.example.mensajeria.repository;

import com.example.mensajeria.model.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MensajeRepository extends MongoRepository<Mensaje, String> {
    List<Mensaje> findBySalaId(String salaId);
}
