package com.eliana.back.dto;

import com.eliana.back.model.CompanyModel;
import com.eliana.back.model.UsuarioModel;

import lombok.Data;
import java.util.List;

@Data
public class CompanyUserDTO {
    private UsuarioModel user;
    private List<UsuarioModel> userList;
    private CompanyModel company;
}
