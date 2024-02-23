package org.example.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservaDTO {
    private Integer id;
    private Integer personaId;
    private Date fecha;
    private Integer paqueteTuristicoId;
    private Integer numeroPersonas;
}
