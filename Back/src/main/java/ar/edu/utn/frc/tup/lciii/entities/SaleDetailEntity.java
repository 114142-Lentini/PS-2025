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
@Table(name = "Detalle_Ventas")
@Data
public class SaleDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "cantidad_bolsa")
    private Integer bagCount;
    @Column(name = "precinto_desde")
    private LocalDateTime sealBegin;
    @Column(name = "precinto_hasta")
    private LocalDateTime sealEnd;
}
