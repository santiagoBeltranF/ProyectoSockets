package org.example.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Persona  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String identificacion;

    private String direccion;

    private String telefono;

    private String email;
}
