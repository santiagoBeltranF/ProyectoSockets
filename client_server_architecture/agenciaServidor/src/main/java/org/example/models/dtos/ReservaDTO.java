package org.example.models.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ReservaDTO {
    private Integer id;
    private String  personaId;
    private Date fecha;
    private Integer paqueteTuristicoId;
    private Integer numeroPersonas;
}
