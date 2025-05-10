package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.entities.GeneratorEntity;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.repositories.GeneratorRepository;
import ar.edu.utn.frc.tup.lciii.services.GeneratorService;
import ar.edu.utn.frc.tup.lciii.services.SaleService;
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
    @Autowired
    private EnvioCorreosServiceImpl emailService;
    public Generator registrationGenerator(GeneratorDto o) {
        GeneratorEntity generatorSave = modelMapper.map(o, GeneratorEntity.class);
        //TODO: Validaciones
        generatorSave.setState("Pendiente");
        generatorSave.setType(o.getType());
        generatorSave.setContact(o.getContact());
        GeneratorEntity generatorEntity = repository.save(generatorSave);
        //TODO: Aca mandar el correo al cliente con el link de la pag
        emailService.enviarCorreo(o.getEmail(),"Registro", "Se ha hecho la solicitud de registro");

        return modelMapper.map(generatorEntity,Generator.class);
    }

    @Override
    public Generator withdrawalGenerator(String name) {
        GeneratorEntity generatorWithdrawal = repository.getGeneratorEntityByName(name);
        //TODO: Validaciones
        generatorWithdrawal.setState("Pendiente Baja");
        repository.save(generatorWithdrawal);
        return modelMapper.map(generatorWithdrawal, Generator.class);
    }

    @Override
    public Generator aproveWithdrawalGenerator(Boolean bool, Long id) {
        Optional<GeneratorEntity> generator = repository.findById(id);
        //TODO: VALIDACIONES
        if(generator.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la solicitud");
        }
        if (!bool) {
            generator.get().setState("Activo");
        } else {
            generator.get().setState("Inactivo");
            generator.get().setExitDate(LocalDateTime.now());
        }
        GeneratorEntity generatorEntity = repository.save(generator.get());
        //Todo: Aca mandar correo
        emailService.enviarCorreo(generatorEntity.getEmail(),"Baja", "Se ha aprobado su solicitud de baja al servicio");
        return modelMapper.map(generatorEntity, Generator.class);
    }

    @Override
    public Generator aproveGenerator(Boolean bool, Long id) {
        Optional<GeneratorEntity> generator = repository.findById(id);
        //TODO:VALIDACIONES
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
        emailService.enviarCorreo(generatorEntity.getEmail(),"Registro", "Se ha aprobado su solicitud de adhesión al servicio");
        return modelMapper.map(generatorEntity, Generator.class);
    }
}
