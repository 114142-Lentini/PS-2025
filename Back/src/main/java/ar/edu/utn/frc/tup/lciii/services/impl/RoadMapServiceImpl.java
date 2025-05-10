package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.RoadmapDto;
import ar.edu.utn.frc.tup.lciii.entities.RoadmapEntity;
import ar.edu.utn.frc.tup.lciii.models.Roadmap;
import ar.edu.utn.frc.tup.lciii.repositories.RoadmapRepository;
import ar.edu.utn.frc.tup.lciii.services.RoadMapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class RoadMapServiceImpl implements RoadMapService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoadmapRepository repository;
    public Roadmap createRoadMap(RoadmapDto roadMap) {
        RoadmapEntity roadmapEntity = modelMapper.map(roadMap, RoadmapEntity.class);
        roadmapEntity.setDate(LocalDateTime.now());
        roadmapEntity.setCollectHour(LocalTime.parse(roadMap.getCollectHour()));
        //El empleado se pone dps
        //roadmapEntity.setEmployee();
        return modelMapper.map(repository.save(roadmapEntity), Roadmap.class);
    }
}
