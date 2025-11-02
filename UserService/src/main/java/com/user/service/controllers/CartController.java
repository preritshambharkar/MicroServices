package com.user.service.controllers;

import com.user.service.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @RequestMapping(value = "/{userId}/vehicle/{vehicleId}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<User> getCartDetails() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
