package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.DummyModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DummyService {
    DummyModel getGetDummy(Long id);
    List<DummyModel> getDummyList();
    DummyModel createDummy(DummyModel dummyModel);
    DummyModel putDummy(DummyModel dummyModel);
    void deleteDummy(DummyModel dummyModel);
}
