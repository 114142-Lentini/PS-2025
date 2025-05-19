package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.entities.EmployeesEntity;
import ar.edu.utn.frc.tup.lciii.entities.OrdersEntity;
import ar.edu.utn.frc.tup.lciii.entities.RoadmapEntity;
import ar.edu.utn.frc.tup.lciii.entities.VehiclesEntity;
import ar.edu.utn.frc.tup.lciii.entities.ZoneEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminNeedsService {
    List<ZoneEntity> getZones();
    List<VehiclesEntity> getVehicles();
    List<EmployeesEntity> getEmployees();


    List<OrdersEntity> getOrdersByZone(String zone);
}
