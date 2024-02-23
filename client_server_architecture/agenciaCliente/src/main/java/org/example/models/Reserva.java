package org.example.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
@Table(name = "core_reservas")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Persona persona;

    private Date fecha;


    private PaqueteTuristico paqueteTuristico;

    private Integer numeroPersonas;

    public Integer getPersonaId() { return persona != null ? persona.getId() : null; }

    public Integer getPaqueteTuristicoId() { return paqueteTuristico != null ? paqueteTuristico.getId() : null; }

}
