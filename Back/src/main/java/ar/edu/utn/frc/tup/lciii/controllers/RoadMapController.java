package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.RoadmapDto;
import ar.edu.utn.frc.tup.lciii.services.RoadMapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("roadmap")
public class RoadMapController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoadMapService roadMapService;
    @PostMapping("/crear")
    public ResponseEntity<RoadmapDto> createRoadMap(@RequestBody RoadmapDto roadmapDto){
        RoadmapDto roadmapDto1 =  modelMapper.map(roadMapService.createRoadMap(roadmapDto), RoadmapDto.class);
        return ResponseEntity.ok(roadmapDto1);
    }
}
