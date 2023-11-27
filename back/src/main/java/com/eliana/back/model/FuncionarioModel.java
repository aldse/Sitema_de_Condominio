package com.eliana.back.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Document("funcionario")
public class FuncionarioModel extends UsuarioModel{
    private Date agendamentocoletadelixo;
    private String descricaocoletadelixo;
    private Date agendamentodeassembleias;
    private String descricaoassembleias;
    private String denuncias;
    private Date agendamentodeeleicoes;
    private String descricaoeleicoes;
}

