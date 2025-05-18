package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Generadores")
@Data
public class GeneratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long generatorId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "fecha_alta")
    private LocalDateTime entryDate;

    @Column(name = "fecha_baja")
    private LocalDateTime exitDate;

    @Column
    private String email;

    @Column(name = "contacto")
    private String contact;

    @Column(name = "tipo")
    private String type;

    @Column(name = "domicilio")
    private String address;

    @Column(name = "estado")
    private String state;

    @OneToMany(mappedBy = "generatorEntity", cascade = CascadeType.ALL)
    private List<SealEntity> seals;

    @OneToMany(mappedBy = "generatorEntity", cascade = CascadeType.ALL)
    private List<RoadmapDetailEntity> details;
}

