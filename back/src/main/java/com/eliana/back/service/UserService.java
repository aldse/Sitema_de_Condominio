package com.eliana.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliana.back.model.UsuarioModel;
import com.eliana.back.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UsuarioModel save(UsuarioModel UsuarioModel) {
        return this.userRepository.save(UsuarioModel);
    }

    public void save(String id, String nome, String cpf) {
        this.userRepository.save(new UsuarioModel(id, nome, cpf));
    }

    public List<UsuarioModel> findAll() {
        return (List<UsuarioModel>) this.userRepository.findAll();
    }

    public List<UsuarioModel> findBynome(String nome) {
        return (List<UsuarioModel>) this.userRepository.findBynome(nome);
    }

    public UsuarioModel findByEmail(String email) {
        return (UsuarioModel) this.userRepository.findByEmail(email);
    }

    public List<UsuarioModel> findByAgeAndnome(short age, String nome) {
        return (List<UsuarioModel>) this.userRepository.findByAgeAndnome(age, nome);
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

    public List<UsuarioModel> findBycpfAndnome(short cpf, String nome) {
        return null;
    }

}
