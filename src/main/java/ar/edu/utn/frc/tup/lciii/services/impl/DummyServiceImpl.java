package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.models.DummyModel;
import ar.edu.utn.frc.tup.lciii.repositories.DummyRepository;
import ar.edu.utn.frc.tup.lciii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {
    @Autowired
    private DummyRepository dummyRespository;
    @Override
    public DummyModel getGetDummy(Long id) {
        return null;
    }

    @Override
    public List<DummyModel> getDummyList() {
        return List.of();
    }

    @Override
    public DummyModel createDummy(DummyModel dummyModel) {
        return null;
    }

    @Override
    public DummyModel putDummy(DummyModel dummyModel) {
        return null;
    }

    @Override
    public void deleteDummy(DummyModel dummyModel) {

    }
}
