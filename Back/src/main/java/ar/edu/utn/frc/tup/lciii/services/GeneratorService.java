package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneratorService {
    Generator registrationGenerator(GeneratorDto o);
    Generator withdrawalGenerator(String name);
    Generator aproveWithdrawalGenerator(Boolean bool, Long cuit);
    Generator aproveGenerator(Boolean bool, Long cuit);
    List<Generator> getAllACtiveGenerator();
    List<Generator> getAllPendingGenerator();

}
