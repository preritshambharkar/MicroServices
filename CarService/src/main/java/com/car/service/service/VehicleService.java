package com.car.service.service;

import com.car.service.entities.Vehicles;

public interface VehicleService {

    public Vehicles getCarDetails(String carId);

    public Vehicles saveCarDetails(Vehicles car);

}
