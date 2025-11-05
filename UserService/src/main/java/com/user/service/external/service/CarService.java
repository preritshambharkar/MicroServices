package com.user.service.external.service;

import com.car.service.entities.Vehicles;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CARSERVICE")
public interface CarService {

    @RequestMapping(value = "/vehicle/{vehicleId}", method = RequestMethod.GET)
    public Vehicles getVehicleDetails(@PathVariable("vehicleId") String vehicleId);

}
