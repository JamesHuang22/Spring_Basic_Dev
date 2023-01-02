package com.example.jpademo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
@Builder(toBuilder = true)
public class UserDTO {

    private String name;
    private int age;
    private String companyName;
    private String schoolName;
    private int yoe;
}
