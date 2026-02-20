package com.user.service.controllers;

import com.user.service.service.UserService;
import com.user.service.entities.User;
import com.user.service.service.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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

    private static int retryCount = 1;

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
//  This is Circuit Breaker Annotation after implementation properties we can use this case of another service down time
//  @CircuitBreaker(name = "carServiceVehicleDetailBreakers", fallbackMethod = "carServiceVehicleDetailsFallback")

//  This is Retry Annotation after implement properties, retry logic will make call during down time of another service
//  @Retry(name = "carServiceVehicleDetail", fallbackMethod = "carServiceVehicleDetailsFallback")
    @RateLimiter(name="carServiceVehicleDetailRateLimiter", fallbackMethod = "carServiceVehicleDetailsFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
//        log.info("retryCount ===========" + retryCount);
//        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<Long> deleteUser(@PathVariable String userId) {
        long user = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //this is fallback method need to be declear so that we can get some response if another service is Down
    public ResponseEntity<User> carServiceVehicleDetailsFallback(String userId, Exception ex) {
        log.info("fallback is executed because service is down "+  ex.getMessage());
        User user = new User();
        user.setEmail("dummy@usergmail.com");
        user.setFirst_name("Dummy firstname");
        user.setFirst_name("Dummy lastname");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
