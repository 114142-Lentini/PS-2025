package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.entities.GeneratorEntity;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.repositories.GeneratorRepository;
import ar.edu.utn.frc.tup.lciii.services.GeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Autowired
    private GeneratorRepository generatorRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Generator postGenerator(GeneratorDto o) {
        GeneratorEntity generatorEntity = generatorRepository.save(modelMapper.map(o, GeneratorEntity.class));
        return modelMapper.map(generatorEntity,Generator.class);
    }
}
