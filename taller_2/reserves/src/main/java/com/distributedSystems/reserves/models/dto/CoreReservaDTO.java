package com.distributedSystems.reserves.models.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
public class CoreReservaDTO {
    private Integer id;
    private Integer numeroPersonas;
    private Date fecha;
    private Integer paqueteTuristicoId;
    private Integer personaId;

}
