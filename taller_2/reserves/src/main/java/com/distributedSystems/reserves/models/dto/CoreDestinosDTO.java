package com.distributedSystems.reserves.models.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CoreDestinosDTO {
    private Integer id;
    private String nombre;
    private String foto;
    private Integer paqueteTuristicoId;
}
