package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.services.impl.GeneratorServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Generator")
@CrossOrigin(origins = "http://localhost:4200")

public class GeneratorController {
    @Autowired
    private GeneratorServiceImpl service;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Pong");
    }
    @PostMapping("")
    public ResponseEntity<GeneratorDto> registrationGenerator(@RequestBody GeneratorDto generatorDto){
        try {
            Generator generator = service.registrationGenerator(generatorDto);
            GeneratorDto generatorDto1 = new GeneratorDto();
            generatorDto1.setContact(generator.getContact());
            generatorDto1.setName(generator.getName());
            generatorDto1.setEmail(generator.getEmail());
            //return ResponseEntity.ok("Solicitud exitosa, se le enviara un correo con los requisitos");
            return ResponseEntity.ok(generatorDto1);
        } catch (Exception exception) {
            throw new IllegalArgumentException("Datos Incorrectos");
        }
    }
    @PutMapping("")
    public ResponseEntity<String> withdrawalGenerator(String name) {
        try {
            Generator generator = service.withdrawalGenerator(name);
            return ResponseEntity.ok("Solicitud de baja exitosa, se le comunicara cuando sea aprobada");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al dar de baja");
        }
    }
    @GetMapping("/activos")
    public ResponseEntity<List<GeneratorDto>> getAllActiveGenerators() {
        List<Generator> generators = service.getAllACtiveGenerator();
        List<GeneratorDto> generatorDtos = new ArrayList<>();
        for (Generator generator : generators) {
            generatorDtos.add(modelMapper.map(generator, GeneratorDto.class));
        }
        return ResponseEntity.ok(generatorDtos);
    }
    @GetMapping("/pendientes")
    public ResponseEntity<List<GeneratorDto>> getAllPendingGenerators() {
        List<Generator> generators = service.getAllPendingGenerator();
        List<GeneratorDto> generatorDtos = new ArrayList<>();
        for (Generator generator : generators) {
            generatorDtos.add(modelMapper.map(generator, GeneratorDto.class));
        }
        return ResponseEntity.ok(generatorDtos);
    }
}
