package com.eliana.back.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Date;

@Data
@Document("adm")
public class AdmCondominioModel extends UsuarioModel{
    private String historicoFuncionarios;
    private String registroCameras;
}

