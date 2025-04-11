package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.entities.GeneratorEntity;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.repositories.GeneratorRepository;
import ar.edu.utn.frc.tup.lciii.services.GeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Autowired
    private GeneratorRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public Generator registrationGenerator(GeneratorDto o, String type) {
        GeneratorEntity generatorSave = modelMapper.map(o, GeneratorEntity.class);
        generatorSave.setState("Pendiente");
        generatorSave.setType(type);
        GeneratorEntity generatorEntity = repository.save(generatorSave);
        //TODO: Aca mandar el correo al cliente
        return modelMapper.map(generatorEntity,Generator.class);
    }

    @Override
    public Generator withdrawalGenerator(String name) {
        GeneratorEntity generatorWithdrawal = repository.getGeneratorEntityByName(name);
        generatorWithdrawal.setState("Pendiente Baja");
        repository.save(generatorWithdrawal);
        return modelMapper.map(generatorWithdrawal, Generator.class);
    }

    @Override
    public Generator aproveWithdrawalGenerator(Boolean bool, Long id) {
        Optional<GeneratorEntity> generator = repository.findById(id);
        if(generator.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la solicitud");
        }
        if (!bool) {
            generator.get().setState("Activo");
            repository.save(generator.get());
        } else {
            generator.get().setState("Inactivo");
        }
        generator.get().setExitDate(LocalDateTime.now());
        GeneratorEntity generatorEntity = repository.save(generator.get());
        return modelMapper.map(generatorEntity, Generator.class);
    }

    @Override
    public Generator aproveGenerator(Boolean bool, Long id) {
        Optional<GeneratorEntity> generator = repository.findById(id);
        if(generator.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la solicitud");
        }
        if (!bool) {
                generator.get().setState("No Aprobado");
                repository.save(generator.get());
        } else {
            generator.get().setState("Activo");
        }
        generator.get().setEntryDate(LocalDateTime.now());
        GeneratorEntity generatorEntity = repository.save(generator.get());
        //Todo: Aca mandar correo
        return modelMapper.map(generatorEntity, Generator.class);
    }
}
