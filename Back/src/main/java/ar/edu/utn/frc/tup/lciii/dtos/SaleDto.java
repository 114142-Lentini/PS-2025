package ar.edu.utn.frc.tup.lciii.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleDto {
    private Long generatorId;
    private Double totalBuy;
    private Integer bagCount;
    private String type;
}
