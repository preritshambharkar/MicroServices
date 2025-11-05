package com.user.service.controllers;

import com.user.service.service.UserService;
import com.user.service.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<Long> deleteUser(@PathVariable String userId) {
        long user = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
