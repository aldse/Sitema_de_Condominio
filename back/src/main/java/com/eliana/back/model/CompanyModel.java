package com.eliana.back.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("company")
public class CompanyModel {
    @Id
    private String id;
    private String name;
    @DBRef
    private UsuarioModel idUser;
    @DBRef
    private List<UsuarioModel> listUser;

    public CompanyModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyModel(String name) {
        this.name = name;
    }

    public CompanyModel() {
    }

    public String getNome() {
        return null;
    }
}
