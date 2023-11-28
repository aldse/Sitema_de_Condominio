package com.eliana.back.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eliana.back.model.CondominioModel;

import java.util.List;

public interface CondominioRepository extends MongoRepository<CondominioModel, String> {
    @Query("{'idUsuario.id': ?0 }")
    List<CondominioModel> findByUsuarioID(String usuarioId);   
}
