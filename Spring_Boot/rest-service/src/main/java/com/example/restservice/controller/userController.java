package com.example.restservice.controller;


import com.example.restservice.model.User;
import com.example.restservice.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        //TODO: Need implementation
        return null;
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        //TODO: Need implementation
        return null;
    }

    @GetMapping("/getByName")
    public User getUserByName(@RequestParam("name") String name) {
        //TODO: Need implementation
        return null;
    }

}
