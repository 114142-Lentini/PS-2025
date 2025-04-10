package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Generadores")
public class GeneratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private  String name;
    @Column
    private LocalDateTime entryDate;
    @Column
    private LocalDateTime exitDate;
    @Column
    private String email;
    @Column
    private String contacto;
    @Column
    private String type;
}
