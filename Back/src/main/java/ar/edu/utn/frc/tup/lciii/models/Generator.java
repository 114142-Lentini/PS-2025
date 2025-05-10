package ar.edu.utn.frc.tup.lciii.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Generator {
    private Long id;
    private String name;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private String email;
    private String contact;
    private String type;
    private String address;
}
