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
import com.eliana.back.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UsuarioModel> getAllUser() {
        List<UsuarioModel> listRes = userService.findAll();
        return listRes;
    }

    // @PostMapping("/file")
    // public void testeFIle(MultipartFile file) throws IOException {
    // userService.saveImcpf(file);
    // }

    @GetMapping("/{nome}")
    public List<UsuarioModel> getUserBynome(@PathVariable String nome) {
        List<UsuarioModel> listRes = userService.findBynome(nome);
        return listRes;
    }

    @GetMapping("/{cpf}/{nome}")
    public List<UsuarioModel> getUserBycpfAndnome(@PathVariable short cpf, @PathVariable String nome) {
        List<UsuarioModel> listRes = userService.findBycpfAndnome(cpf, nome);
        return listRes;
    }

    @PostMapping("")
    public void newUser(@RequestBody UsuarioModel newUser) {
        userService.save(newUser);
    }

    @PutMapping("/{id}")
    public void putUser(@RequestBody UsuarioModel newUser, @PathVariable String id) {
        userService.save((String) id, (String) newUser.getNome(), (String) newUser.getCpf());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }

}
