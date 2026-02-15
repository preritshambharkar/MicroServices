package com.car.service.service;

import com.car.service.entities.Vehicles;
import java.util.List;

public interface VehicleService {

    public List getCarDetails(String carId);

    public Vehicles saveCarDetails(Vehicles car);

}
