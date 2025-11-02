package com.car.service.controllers;


import com.car.service.entities.Vehicles;
import com.car.service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private VehicleService carService;


    @RequestMapping(value = "/{vehicleId}", method = RequestMethod.GET)
    public ResponseEntity<Vehicles> getCarDetails(@PathVariable String vehicleId) {
        Vehicles car = new Vehicles();
        car = carService.getCarDetails(vehicleId);
        return ResponseEntity.ok(car);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<Vehicles> createCarDetails(@RequestBody Vehicles carDetails) {
        Vehicles car = new Vehicles();
        car = carService.saveCarDetails(carDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }



}
