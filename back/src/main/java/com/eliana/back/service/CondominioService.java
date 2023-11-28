package com.eliana.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliana.back.model.CondominioModel;
import com.eliana.back.repository.CondominioRepository;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    public void save(CondominioModel condominioModel) {
        this.condominioRepository.save(condominioModel);
    }

    public List<CondominioModel> findAll() {
        return this.condominioRepository.findAll();
    }

    public List<CondominioModel> findByUserID(String usuarioId) {
        return this.condominioRepository.findByUsuarioID(usuarioId);
    }

    public void delete(String id) {
        this.condominioRepository.deleteById(id);
    }

    public List<CondominioModel> findByUsuarioID(String usuarioId) {
        return null;
    }

}
