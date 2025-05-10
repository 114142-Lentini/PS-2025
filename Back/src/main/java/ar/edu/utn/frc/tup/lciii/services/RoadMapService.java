package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.RoadmapDto;
import ar.edu.utn.frc.tup.lciii.models.Roadmap;
import org.springframework.stereotype.Service;

@Service
public interface RoadMapService {
    Roadmap createRoadMap(RoadmapDto roadMap);
}
