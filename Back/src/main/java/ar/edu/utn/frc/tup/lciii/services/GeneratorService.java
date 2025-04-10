package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import org.springframework.stereotype.Service;

@Service
public interface GeneratorService {
    Generator postGenerator(GeneratorDto o);
}
