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
    @DBRef
    private UsuarioModel idUsuario;
    @DBRef
    private List<UsuarioModel> listUsuario;

    public CondominioModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CondominioModel(String name) {
        this.name = name;
    }

    public CondominioModel() {
    }

    public String getNome() {
        return null;
    }
}
