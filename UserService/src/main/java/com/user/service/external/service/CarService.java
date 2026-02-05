package com.user.service.external.service;

import com.user.service.vo.Vehicles;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CAR-SERVICE")
public interface CarService {

    @RequestMapping(value = "/vehicle/{vehicleId}", method = RequestMethod.GET)
    public ResponseEntity<Vehicles> getVehicleDetails(@PathVariable("vehicleId") String vehicleId);

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    public Vehicles createVehicles(Vehicles vehicle);

}
