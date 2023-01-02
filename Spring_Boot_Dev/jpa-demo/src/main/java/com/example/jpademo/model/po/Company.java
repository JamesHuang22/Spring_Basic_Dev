package com.example.jpademo.model.po;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    unique in @Column is used only if you let your JPA provider create the database for you -
    it will create the unique constraint on the specified column. But if you already have the database,
    or you alter it once created, then unique doesn't have any effect.
     */
    @Column(unique = true)
    private String companyName;
    private String description;
}
