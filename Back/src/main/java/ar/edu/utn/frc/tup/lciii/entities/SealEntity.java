package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Precintos")
@Data
public class SealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precinto", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "generatorId", nullable = false)
    private GeneratorEntity generatorEntity;

    @Column(name = "nro_precinto")
    private Integer sealNumber;
}

