package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.EmployeesEntity;
import ar.edu.utn.frc.tup.lciii.entities.OrdersEntity;
import ar.edu.utn.frc.tup.lciii.entities.RoadmapEntity;
import ar.edu.utn.frc.tup.lciii.entities.VehiclesEntity;
import ar.edu.utn.frc.tup.lciii.entities.ZoneEntity;
import ar.edu.utn.frc.tup.lciii.repositories.EmployeeRepository;
import ar.edu.utn.frc.tup.lciii.repositories.OrdersRepository;
import ar.edu.utn.frc.tup.lciii.repositories.RoadmapRepository;
import ar.edu.utn.frc.tup.lciii.repositories.VehicleRepository;
import ar.edu.utn.frc.tup.lciii.repositories.ZoneRepository;
import ar.edu.utn.frc.tup.lciii.services.AdminNeedsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminNeedsServiceImpl implements AdminNeedsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<ZoneEntity> getZones() {
        return zoneRepository.findAll();
    }

    @Override
    public List<VehiclesEntity> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<EmployeesEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<OrdersEntity> getOrdersByZone(String zone) {
        ZoneEntity zoneEntity = zoneRepository.findByName(zone);
        return ordersRepository.findAllByZoneEntity(zoneEntity);
    }

}
