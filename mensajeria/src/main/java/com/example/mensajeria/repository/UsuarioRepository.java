package com.example.mensajeria.repository;

import com.example.mensajeria.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Métodos personalizados opcionales
}
