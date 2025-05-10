package ar.edu.utn.frc.tup.lciii.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roadmap {
    private Long id;
    private Integer countBags;
    private LocalDateTime date;
    private LocalDateTime collectDate;
    private LocalTime collectHour;
    private String employee;
    private Double initialKm;
    private Double finalKm;
    private LocalDateTime exitHour;
    private LocalDateTime returnHour;
}
