package com.user.service.service;

import com.user.service.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUserDetails();
    User getUser(UUID userId);
    UUID deleteUser(UUID userId);
    int updateUser(User user);

}
