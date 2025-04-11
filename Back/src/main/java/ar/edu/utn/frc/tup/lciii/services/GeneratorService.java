package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import org.springframework.stereotype.Service;

@Service
public interface GeneratorService {
    Generator registrationGenerator(GeneratorDto o, String type);
    Generator withdrawalGenerator(String name);
    Generator aproveWithdrawalGenerator(Boolean bool, Long id);
    Generator aproveGenerator(Boolean bool, Long id);
}
