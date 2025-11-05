package com.user.service.controllers;

import com.user.service.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @RequestMapping(value = "/{userId}/vehicle/{vehicleId}", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<User> addToCarts(@PathVariable("userId") String userId, @PathVariable("vehicleId") String vehicleId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
