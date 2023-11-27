package com.eliana.back.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliana.back.dto.CondominioUsuarioDTO;
import com.eliana.back.model.CondominioModel;
import com.eliana.back.model.UsuarioModel;
import com.eliana.back.service.CondominioService;
import com.eliana.back.service.UsuarioService;

@RestController
@RequestMapping("/condominio")
public class CondominioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CondominioService condominioService;

    @PostMapping("")
    public void newUsuario(@RequestBody CondominioUsuarioDTO newCondominioUsuarioDTO) {
        CondominioModel newCondominioModel = new CondominioModel(newCondominioUsuarioDTO.getCondominio().getNome());

        UsuarioModel usuarioResp = usuarioService
                .save(new UsuarioModel(newCondominioUsuarioDTO.getUsuario().getNome(), newCondominioUsuarioDTO.getUsuario().getCpf()));
        newCondominioModel.setIdUsuario(new UsuarioModel(UsuarioResp.getId()));
        CondominioService.save(newCondominioModel);
    }

    @PostMapping("/array")
    public void newUsuarioArray(@RequestBody CondominioUsuarioDTO newCondominioUsuarioDTO) {
        List<UsuarioModel> idsUsuarios = new ArrayList<UsuarioModel>();

        for (UsuarioModel test : newCondominioUsuarioDTO.getUsuarioList()) {
            UsuarioModel usuarioResp = usuarioService.save(new UsuarioModel(test.getNome(), test.getCpf()));
            idsUsuarios.add(new UsuarioModel(usuarioResp.getId()));
        }

        CondominioModel newCondominioModel = new CondominioModel(newCondominioUsuarioDTO.getCondominio().getNome());

        newCondominioModel.setListUsuario(idsUsuarios);
        condominioService.save(newCondominioModel);
    }

    @GetMapping("")
    public List<CondominioModel> findAllCondominioModels() {
        return condominioService.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<CondominioModel> findByUsuarioID(@PathVariable String usuarioId) {
        return condominioService.findByUsuarioID(usuarioId);
    }

    @DeleteMapping("/{id}")
    public void deleteCondominio(@PathVariable String id) {
        condominioService.delete(id);
    }
}
