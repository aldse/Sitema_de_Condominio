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

import com.eliana.back.dto.CompanyUserDTO;
import com.eliana.back.model.CompanyModel;
import com.eliana.back.model.UsuarioModel;
import com.eliana.back.service.CompanyService;
import com.eliana.back.service.UserService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public void newUser(@RequestBody CompanyUserDTO newCompanyUserDTO) {
        CompanyModel newCompanyModel = new CompanyModel(newCompanyUserDTO.getCompany().getNome());

        UsuarioModel userResp = userService
                .save(new UsuarioModel(newCompanyUserDTO.getUser().getNome(), newCompanyUserDTO.getUser().getCpf()));
        newCompanyModel.setIdUser(new UsuarioModel(userResp.getId()));
        companyService.save(newCompanyModel);
    }

    @PostMapping("/array")
    public void newUserArray(@RequestBody CompanyUserDTO newCompanyUserDTO) {
        List<UsuarioModel> idsUsers = new ArrayList<UsuarioModel>();

        for (UsuarioModel test : newCompanyUserDTO.getUserList()) {
            UsuarioModel userResp = userService.save(new UsuarioModel(test.getNome(), test.getCpf()));
            idsUsers.add(new UsuarioModel(userResp.getId()));
        }

        CompanyModel newCompanyModel = new CompanyModel(newCompanyUserDTO.getCompany().getNome());

        newCompanyModel.setListUser(idsUsers);
        companyService.save(newCompanyModel);
    }

    @GetMapping("")
    public List<CompanyModel> findAllCompanyModels() {
        return companyService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<CompanyModel> findByUserID(@PathVariable String userId) {
        return companyService.findByUserID(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable String id) {
        companyService.delete(id);
    }
}
