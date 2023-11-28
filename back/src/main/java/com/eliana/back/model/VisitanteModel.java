package com.eliana.back.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Date;

@Data
@Document("visitante")
public class VisitanteModel extends UsuarioModel{
    
}

