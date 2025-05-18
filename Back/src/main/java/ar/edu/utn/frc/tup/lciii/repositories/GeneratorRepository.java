package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.entities.GeneratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneratorRepository extends JpaRepository<GeneratorEntity,Long> {
    GeneratorEntity getGeneratorEntityByName(String name);
    List<GeneratorEntity> getGeneratorEntityByState(String state);

}
