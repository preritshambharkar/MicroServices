package com.user.service.controllers;

import com.user.service.service.UserService;
import com.user.service.entities.User;
import com.user.service.service.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<User>> getAllUsers() {
        List users = userService.getAllUserDetails();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {"application/json"})
    @CircuitBreaker(name = "carServiceVehicleDetailBreakers", fallbackMethod = "carServiceVehicleDetailsFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<Long> deleteUser(@PathVariable String userId) {
        long user = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    public ResponseEntity<User> carServiceVehicleDetailsFallback(String userId, Exception ex) {
        log.info("fallback is executed because service is down "+  ex.getMessage());
        User user = new User();
        user.setEmail("dummy@usergmail.com");
        user.setFirst_name("Dummy firstname");
        user.setFirst_name("Dummy lastname");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
