package com.eliana.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliana.back.model.UsuarioModel;
import com.eliana.back.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public List<UsuarioModel> getAllUsuario() {
        List<UsuarioModel> listRes = usuarioService.findAll();
        return listRes;
    }

    // @PostMapping("/file")
    // public void testeFIle(MultipartFile file) throws IOException {
    // userService.saveImcpf(file);
    // }

    @GetMapping("/{nome}")
    public List<UsuarioModel> getUsuarioBynome(@PathVariable String nome) {
        List<UsuarioModel> listRes = usuarioService.findBynome(nome);
        return listRes;
    }

    @GetMapping("/{cpf}/{nome}")
    public List<UsuarioModel> getUsuarioBycpfAndnome(@PathVariable short cpf, @PathVariable String nome) {
        List<UsuarioModel> listRes = usuarioService.findBycpfAndnome(cpf, nome);
        return listRes;
    }

    @PostMapping("")
    public void newUsuario(@RequestBody UsuarioModel newUsuario) {
        usuarioService.save(newUsuario);
    }

    @PutMapping("/{id}")
    public void putUsuario(@RequestBody UsuarioModel newUsuario, @PathVariable String id) {
        usuarioService.save((String) id, (String) newUsuario.getNome(), (String) newUsuario.getCpf());
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioService.delete(id);
    }

}
