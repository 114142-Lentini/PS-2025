package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.services.impl.GeneratorServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Generator")
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
    public ResponseEntity<String> registrationGenerator(GeneratorDto generatorDto, String type){
        try {
            Generator generator = service.registrationGenerator(generatorDto, type);
            GeneratorDto generatorDto1 = new GeneratorDto();
            generatorDto1.setContacto(generator.getContacto());
            generatorDto1.setName(generator.getName());
            generatorDto1.setEmail(generator.getEmail());
            return ResponseEntity.ok("Solicitud exitosa, se le enviara un correo con los requisitos");
        } catch (Exception exception) {
            throw new IllegalArgumentException("Datos Incorrectos");
        }
    }
    @PutMapping("")
    public ResponseEntity<String> withdrawalGenerator(String name) {
        try {
            Generator generator = service.withdrawalGenerator(name);
            return ResponseEntity.ok("Éxito");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al dar de baja");
        }
    }
}
