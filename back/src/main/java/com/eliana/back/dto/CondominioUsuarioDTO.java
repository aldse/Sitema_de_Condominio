package com.eliana.back.dto;

import com.eliana.back.model.CondominioModel;
import com.eliana.back.model.UsuarioModel;

import lombok.Data;
import java.util.List;

@Data
public class CondominioUsuarioDTO {
    private UsuarioModel usuario;
    private List<UsuarioModel> usuarioList;
    private CondominioModel condominio;
}
