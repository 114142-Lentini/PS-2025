package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.EmployeeDto;
import ar.edu.utn.frc.tup.lciii.dtos.OrdersDto;
import ar.edu.utn.frc.tup.lciii.dtos.RoadmapDto;
import ar.edu.utn.frc.tup.lciii.dtos.VehicleDto;
import ar.edu.utn.frc.tup.lciii.dtos.ZoneDto;
import ar.edu.utn.frc.tup.lciii.entities.EmployeesEntity;
import ar.edu.utn.frc.tup.lciii.entities.OrdersEntity;
import ar.edu.utn.frc.tup.lciii.entities.RoadmapEntity;
import ar.edu.utn.frc.tup.lciii.entities.VehiclesEntity;
import ar.edu.utn.frc.tup.lciii.entities.ZoneEntity;
import ar.edu.utn.frc.tup.lciii.services.AdminNeedsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminNeedsService adminNeedsService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/zones")
    public ResponseEntity<List<ZoneDto>> getZones(){
        List<ZoneEntity> zoneEntities = adminNeedsService.getZones();
        List<ZoneDto> zoneDtos = new ArrayList<>();
        for (ZoneEntity zoneEntity : zoneEntities) {
            zoneDtos.add(modelMapper.map(zoneEntity, ZoneDto.class));
        }
        return ResponseEntity.ok(zoneDtos);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeesEntity> employees = adminNeedsService.getEmployees();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (EmployeesEntity entity : employees) {
            employeeDtos.add(modelMapper.map(entity, EmployeeDto.class));
        }
        return ResponseEntity.ok(employeeDtos);
    }
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        List<VehiclesEntity> vehiclesEntities = adminNeedsService.getVehicles();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (VehiclesEntity entity : vehiclesEntities) {
            vehicleDtos.add(modelMapper.map(entity, VehicleDto.class));
        }
        return ResponseEntity.ok(vehicleDtos);
    }
    @GetMapping("/pedidos")
    public ResponseEntity<List<OrdersDto>> getOrderByZone(@RequestParam String zone) {
        List<OrdersEntity> ordersEntities = adminNeedsService.getOrdersByZone(zone);
        List<OrdersDto> ordersDtos = new ArrayList<>();
        for (OrdersEntity entity : ordersEntities) {
            OrdersDto ordersDto = modelMapper.map(entity, OrdersDto.class);
            ordersDto.setGenerador(entity.getGeneratorEntity().getName());
            ordersDtos.add(ordersDto);
        }
        return ResponseEntity.ok(ordersDtos);
    }
}
