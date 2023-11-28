package com.eliana.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliana.back.model.UsuarioModel;
import com.eliana.back.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel save(UsuarioModel usuarioModel) {
        return this.usuarioRepository.save(usuarioModel);
    }

    public void save(String id, String nome, String cpf) {
        this.usuarioRepository.save(new UsuarioModel(id, nome, cpf));
    }

    public List<UsuarioModel> findAll() {
        return (List<UsuarioModel>) this.usuarioRepository.findAll();
    }

    public UsuarioModel findByEmail(String email) {
        return (UsuarioModel) this.usuarioRepository.findByEmail(email);
    }

    public void delete(String id) {
        this.usuarioRepository.deleteById(id);
    }

    public List<UsuarioModel> findByNome(String nome) {
        return (List<UsuarioModel>) this.usuarioRepository.findByNome(nome);
    }

    public List<UsuarioModel> findBycpfAndsenha(String cpf, String senha) {
        return (List<UsuarioModel>) this.usuarioRepository.findBycpfAndsenha(cpf, senha);
    }
}
