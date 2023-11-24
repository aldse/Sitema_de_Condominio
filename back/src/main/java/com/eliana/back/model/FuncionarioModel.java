package com.eliana.back.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("funcionario")
public class FuncionarioModel {
    @Id
    private String id;
    private String nome;
    private String senha;
    private String email;
    private String tipo;
    private String cpf;
    private Double salario;

    public FuncionarioModel(String id, String nome, String cpf, Double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public FuncionarioModel(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public FuncionarioModel(String id) {
        this.id = id;
    }

    public FuncionarioModel() {
    }
}
