package com.eliana.back.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("condominio")
public class CondominioModel {
    @Id
    private String id;
    private String name;
    private String cpf;
    private String senha;
    @DBRef
    private UsuarioModel idUsuario;
    @DBRef
    private List<UsuarioModel> listUsuario;

    public CondominioModel(String id, String name, String cpf, String senha) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.senha = senha;
    }

    public CondominioModel(String id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public CondominioModel(String name) {
        this.name = name;
    }

    public CondominioModel(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public CondominioModel() {
    }

    public String getNome() {
        return null;
    }
}
