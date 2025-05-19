package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedidos_Retiro")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_retiro", nullable = false)
    private Long id;
    @Column(name = "estado")
    private String state;
    @ManyToOne
    @JoinColumn(name = "zoneId", nullable = false)
    private ZoneEntity zoneEntity;
    @ManyToOne
    @JoinColumn(name = "generatorId", nullable = false)
    private GeneratorEntity generatorEntity;

}
