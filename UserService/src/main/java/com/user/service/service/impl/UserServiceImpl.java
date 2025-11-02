package com.user.service.service.impl;

import com.user.service.dao.UserDao;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;


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
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User by given Id was not found on records!! : " + userId));
    }

    @Override
    public int deleteUser(String userId) {
        userRepository.deleteById(userId);
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
