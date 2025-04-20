package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.BagDto;
import ar.edu.utn.frc.tup.lciii.models.Bag;
import ar.edu.utn.frc.tup.lciii.services.BagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Bag")
public class BagController {
    @Autowired
    private BagService bagService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("")
    public ResponseEntity<List<BagDto>> getBags() {
        List<Bag> bags = bagService.getAllBags();
        List<BagDto> bagDtos = new ArrayList<>();
        for (Bag bag : bags) {
            bagDtos.add(modelMapper.map(bag, BagDto.class));
        }
        return ResponseEntity.ok(bagDtos);
    }
}
