package com.car.service.service.serviceImpl;

import com.car.service.dao.VehiclesDao;
import com.car.service.entities.Vehicles;
import com.car.service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehiclesDao vehiclesDao;


    @Override
    public Vehicles getCarDetails(String carId) {
        Vehicles vehicle = vehiclesDao.getCarDetails(carId);
        return vehicle;
    }

    @Override
    public Vehicles saveCarDetails(Vehicles car) {
        return vehiclesDao.saveAllVehicleDetails(car);
    }
}
