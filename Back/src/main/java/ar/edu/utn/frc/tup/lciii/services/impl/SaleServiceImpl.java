package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.SaleDto;
import ar.edu.utn.frc.tup.lciii.entities.GeneratorEntity;
import ar.edu.utn.frc.tup.lciii.entities.SaleDetailEntity;
import ar.edu.utn.frc.tup.lciii.entities.SalesEntity;
import ar.edu.utn.frc.tup.lciii.models.Generator;
import ar.edu.utn.frc.tup.lciii.models.Sale;
import ar.edu.utn.frc.tup.lciii.repositories.GeneratorRepository;
import ar.edu.utn.frc.tup.lciii.repositories.SaleDetailRepository;
import ar.edu.utn.frc.tup.lciii.repositories.SaleRepository;
import ar.edu.utn.frc.tup.lciii.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleDetailRepository saleDetailRepository;
    @Autowired
    private GeneratorRepository generatorRepository;
    @Transactional
    public Sale registerSale(SaleDto sale) {
        SalesEntity salesEntity = new SalesEntity();
        salesEntity.setDate(LocalDateTime.now());
        //salesEntity.setGeneratorId(sale.getGeneratorId());
        salesEntity.setTotalBuy(sale.getTotalBuy());
        salesEntity.setType(sale.getType());

        SaleDetailEntity saleDetailEntity = new SaleDetailEntity();
        //saleDetailEntity.setBagCount(sale.getBagCount());
        saleDetailRepository.save(saleDetailEntity);

        SalesEntity saleSave = saleRepository.save(salesEntity);

        return modelMapper.map(saleSave, Sale.class);
    }

    @Override
    public List<Sale> findByGenerator(Long id) {
        GeneratorEntity generatorEntity = generatorRepository.getReferenceById(id);
        List<SalesEntity> salesEntities = saleRepository.findAllByGeneratorEntity(generatorEntity);
        List<Sale> sales = new ArrayList<>();
        for (SalesEntity saleEntity : salesEntities) {
            Sale sale = modelMapper.map(saleEntity, Sale.class);
            sale.setDate(saleEntity.getDate().toLocalDate());
            sales.add(sale);
        }
        return sales;
    }
}
