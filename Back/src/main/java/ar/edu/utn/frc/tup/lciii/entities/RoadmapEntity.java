package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Hojas_Ruta")
@Data
public class RoadmapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roadmap_id", nullable = false)
    private Long roadmapId;
    @Column(name = "fecha_hr")
    private LocalDateTime date;
    @Column(name = "fecha_recoleccion")
    private LocalDateTime collectDate;
    @Column(name = "operario")
    private String employee;
    @Column(name = "km_inicial")
    private Double initialKm;
    @Column(name = "km_final")
    private Double finalKm;
    @Column(name = "hs_salida")
    private LocalTime exitHour;
    @Column(name = "hs_regreso")
    private LocalTime returnHour;
    @Column(name = "hora_recoleccion")
    private LocalTime collectHour;
    @Column(name = "cant_bolsas")
    private Integer countBags;
    // Relación con detalles (opcional)
    // @OneToMany(mappedBy = "roadmapEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<RoadmapDetailEntity> details;

}
