package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.GeneratorDto;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.services.impl.GeneratorServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Generator")
public class GeneratorController {
    @Autowired
    private GeneratorServiceImpl service;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("")
    public ResponseEntity<GeneratorDto> postDummy(GeneratorDto generatorDto){
        Generator generator = service.postGenerator(generatorDto);
        return ResponseEntity.ok(modelMapper.map(generator,GeneratorDto.class));
    }
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Pong");
    }
}
