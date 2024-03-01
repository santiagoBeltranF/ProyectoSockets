package com.distributedSystems.reserves.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@ToString
@Table(name = "core_reserva")
@SQLDelete(sql = "UPDATE core_reserva SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
public class CoreReserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_personas")
    private Integer numeroPersonas;
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "paquete_turistico_id")
    private CorePaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private CorePersona persona;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public Integer getPersonaId() { return persona != null ? persona.getId() : null; }

    public Integer getPaqueteTuristicoId() { return paqueteTuristico != null ? paqueteTuristico.getId() : null; }

}
