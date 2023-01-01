package com.example.restservice.dao;

import com.example.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface userDao extends JpaRepository<User, Integer>{
    List<User> getAllUser();

    int addUser(User user);
}
