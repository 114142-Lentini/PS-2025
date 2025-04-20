package ar.edu.utn.frc.tup.lciii.models;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Sale {
    private Long id;
    private LocalDateTime date;
    private String type;
    private Long generatorId;
    private Double totalBuy;
    private LocalDateTime capitulationDate;
}
