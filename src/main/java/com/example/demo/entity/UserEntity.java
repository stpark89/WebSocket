package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class UserEntity {

    @Id
    @Column(name = "email")
    private String email;

    @Column(length = 100, nullable = false, unique = false)
    private String pwd;



}
