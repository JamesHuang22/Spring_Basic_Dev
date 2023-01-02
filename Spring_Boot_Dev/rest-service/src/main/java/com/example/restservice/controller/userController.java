package com.example.restservice.controller;


import com.example.restservice.dao.userDao;
import com.example.restservice.model.User;
import com.example.restservice.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {
    @Autowired
    private userService userService;

    @Autowired
    private userDao userDao;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> listAll(Model model) {
        List<User> listUser = userDao.findAll();
        return ResponseEntity.ok(listUser);
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        String sex = body.get("sex");
        String password = body.get("password");
        User newUser = userService.addUser(name, email, password, sex);
        log.info("Successfully added a new user {}", newUser);
        return ResponseEntity.ok(newUser);
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
