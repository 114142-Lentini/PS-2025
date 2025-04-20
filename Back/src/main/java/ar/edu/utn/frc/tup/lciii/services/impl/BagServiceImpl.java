package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.BagEntity;
import ar.edu.utn.frc.tup.lciii.models.Bag;
import ar.edu.utn.frc.tup.lciii.models.Sale;
import ar.edu.utn.frc.tup.lciii.repositories.BagRepository;
import ar.edu.utn.frc.tup.lciii.services.BagService;
import ar.edu.utn.frc.tup.lciii.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BagServiceImpl implements BagService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BagRepository bagRepository;
    @Autowired
    private SaleService saleService;

    @Override
    public List<Bag> getAllBags() {
        List<BagEntity> bagEntities = bagRepository.findAll();
        List<Bag> bags = new ArrayList<>();
        for (BagEntity bagEntity : bagEntities) {
            bags.add(modelMapper.map(bagEntity, Bag.class));
        }
        return bags;
    }

    @Override
    public Sale sellBag(Integer numberToSell) {
        return null;
    }
}
