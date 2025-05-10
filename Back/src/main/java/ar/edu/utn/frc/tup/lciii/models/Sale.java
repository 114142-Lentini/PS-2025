package ar.edu.utn.frc.tup.lciii.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Sale {
    private Long id;
    private LocalDateTime date;
    private String type;
    private Long generatorId;
    private Double totalBuy;
}
