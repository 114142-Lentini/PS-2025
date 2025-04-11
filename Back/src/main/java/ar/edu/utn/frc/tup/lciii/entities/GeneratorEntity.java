package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Generadores")
@Data
public class GeneratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre")
    private  String name;
    @Column(name = "fecha_alta")
    private LocalDateTime entryDate;
    @Column(name ="fecha_baja")
    private LocalDateTime exitDate;
    @Column
    private String email;
    @Column(name = "contacto")
    private String contact;
    @Column(name = "tipo")
    private String type;
    @Column(name = "estado")
    private String state;
}
