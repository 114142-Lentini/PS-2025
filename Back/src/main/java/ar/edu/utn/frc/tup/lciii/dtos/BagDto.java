package ar.edu.utn.frc.tup.lciii.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BagDto {
    private String size;
    private Double price;
}
