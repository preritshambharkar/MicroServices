package com.car.service.dao;
import com.car.service.entities.Vehicles;
import java.util.List;

public interface VehiclesDao {

    public Vehicles getCarDetails(String carId);

    public List findAll();

    public Vehicles saveAllVehicleDetails(Vehicles vehicles);
}
