package com.eliana.back.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Document("morador")
public class MoradorModel extends UsuarioModel {
    private String vagaReservada;
    private Double custoCondominioMensal;
    private Date reservaChurrasqueira;
    private String denuncias;
}
