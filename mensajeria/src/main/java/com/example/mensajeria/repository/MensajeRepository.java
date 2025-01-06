package com.example.mensajeria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mensajeria.model.Mensaje;

@Repository
public interface MensajeRepository extends MongoRepository<Mensaje, String> {
    // Puedes agregar métodos personalizados si lo necesitas
}
