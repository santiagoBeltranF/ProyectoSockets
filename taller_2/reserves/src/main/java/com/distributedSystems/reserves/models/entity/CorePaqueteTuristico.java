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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "core_paquetes_turisticos")
@SQLDelete(sql = "UPDATE core_paquetes_turisticos SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
public class CorePaqueteTuristico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "duracion_dias")
    private Integer duracionDias;
    @Column(name = "cupo_maximo")
    private Integer cupoMaximo;
    @Column(name = "valor_paquete")
    private Double valorPaquete;
    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoreDestinos> destinos = new ArrayList<>();

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
}
