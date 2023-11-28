package com.eliana.back.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.eliana.back.model.UsuarioModel;
import java.util.List;

public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {
    @Query("{'nome': ?0}")
    List<UsuarioModel> findByNome(String nome);

    @Query("{'email': ?0}")
    UsuarioModel findByEmail(String email);

    @Query("{'cpf': ?0}, 'senha': ?1")
    List<UsuarioModel> findBycpfAndsenha(String cpf, String senha);

}
