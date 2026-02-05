package com.user.service.service.impl;

import com.user.service.vo.Vehicles;
import com.user.service.dao.UserDao;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.service.CarService;
import com.user.service.repositories.UserRepository;
import com.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CarService carService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUserDetails() {
        return userDao.findAll();
    }

    @Override
    public User getUser(String userId) {
        try {
            /*
                Internal call using load balanced annotation "CAR-SERVICE is name of another
                serve no need to hardcode URL and Port number to access that CAR-SERVICE / another service"
            */
            ArrayList object = restTemplate.getForObject("http://CAR-SERVICE/vehicle/1", ArrayList.class);
            log.info("from HTTP request, but that is dynamic in nature as we are not passing Host and Port details");
        } catch (Exception e) {
            log.error("Exception Occurred : " + e.getMessage() + " " + e);
        }
        try {
            //Calling other microservice using feign client
            ResponseEntity<Vehicles> vehicles = carService.getVehicleDetails("1");
            Vehicles vehicles1 = vehicles.getBody();
            log.info("from Feign client");
        } catch (Exception e) {
            log.error("Exception Occurred  feign client: " + e.getMessage() + " " + e);
        }
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User by given Id was not found on records!! : " + userId));
    }

    @Override
    public long deleteUser(String userId) {
        User user = getUser(userId);
        userRepository.deleteById(userId);
        return Long.parseLong(userId);
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
