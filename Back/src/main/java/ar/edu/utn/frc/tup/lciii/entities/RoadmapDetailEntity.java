package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Detalle_Hojas_Ruta")
@Data
public class RoadmapDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_hr", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roadmapId", nullable = false)
    private RoadmapEntity roadmapEntity;

    @ManyToOne
    @JoinColumn(name = "generatorId", nullable = false)
    private GeneratorEntity generatorEntity;
}
