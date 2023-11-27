package com.eliana.back.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("usuario")
public class UsuarioModel {
    @Id
    private String id;
    private String nome;
    private String senha;
    private String email;
    private String tipo;
    private String cpf;

    public UsuarioModel(String id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public UsuarioModel(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public UsuarioModel(String id) {
        this.id = id;
    }

    public UsuarioModel() {
    }
}
