package com.example.restservice.service;


import com.example.restservice.dao.userDao;
import com.example.restservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class userService {

    private final userDao userDao;

    @Autowired
    public userService(userDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(String name, String email, String password, String sex) {
        UUID userId = UUID.randomUUID();
        User newUser = new User(userId, email, password, name, sex);
        return userDao.save(newUser);
    }




}
