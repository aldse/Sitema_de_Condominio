package com.eliana.back.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.eliana.back.model.UsuarioModel;
import java.util.List;

public interface UserRepository extends MongoRepository<UsuarioModel, String> {
    @Query("{'name': ?0}")
    List<UsuarioModel> findByName(String name);

    @Query("{'email': ?0}")
    UsuarioModel findByEmail(String email);

    @Query("{'name': ?1, 'age': ?0}")
    List<UsuarioModel> findByAgeAndName(short age, String name);

    List<UsuarioModel> findBynome(String nome);

    List<UsuarioModel> findByAgeAndnome(short age, String nome);

}
