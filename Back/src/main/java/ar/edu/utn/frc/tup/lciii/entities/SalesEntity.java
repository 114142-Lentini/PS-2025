package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Ventas")
@Data
public class SalesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "fecha_vta")
    private LocalDateTime date;
    @Column(name = "tipo")
    private String type;
    @Column(name = "id_generador")
    private Long generatorId;
    @Column(name = "total_compra")
    private Double totalBuy;
    @Column(name = "fecha_rendicion_vta")
    private LocalDateTime capitulationDate;
}
