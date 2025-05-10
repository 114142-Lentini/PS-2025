package ar.edu.utn.frc.tup.lciii.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bag {
    private Long id;
    private String size;
    private Double price;
}
