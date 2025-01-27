package com.example.mensajeria.repository;

import com.example.mensajeria.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
