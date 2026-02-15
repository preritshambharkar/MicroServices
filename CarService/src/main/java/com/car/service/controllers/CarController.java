package com.car.service.controllers;


import com.car.service.entities.Vehicles;
import com.car.service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class CarController {

    @Autowired
    private VehicleService carService;


    @RequestMapping(value = "/{vehicleId}", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicles>> getVehicleDetails(@PathVariable String vehicleId) {
        List vehicle;
        vehicle = carService.getCarDetails(vehicleId);
        return ResponseEntity.ok(vehicle);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    public ResponseEntity<Vehicles> createVehicleDetails(@RequestBody Vehicles vehicleDetails) {
        Vehicles vehicle = new Vehicles();
        vehicle = carService.saveCarDetails(vehicleDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }



}
