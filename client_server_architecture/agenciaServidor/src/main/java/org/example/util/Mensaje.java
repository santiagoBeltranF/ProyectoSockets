package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Data
@ToString
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipo;
    private Object contenido;

}
