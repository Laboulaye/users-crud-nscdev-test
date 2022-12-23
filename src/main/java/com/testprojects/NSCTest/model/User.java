package com.testprojects.NSCTest.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Модель пользователя
 */
@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable = false)
    @NotBlank(message = "Firstname is mandatory")
    private String firstName;

    @Column(name="last_name", nullable = false)
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;

    @Column(name="birthday")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    @Column(name="login", nullable = false)
    @NotBlank(message = "Login is mandatory")
    private String login;

    @Column(name="passw", nullable = false)
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Column(name="bio")
    private String bio;

    @Column(name="address")
    private String address;


}
