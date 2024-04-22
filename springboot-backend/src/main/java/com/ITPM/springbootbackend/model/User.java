package com.ITPM.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;
    private String name;
    private String userName;
    private String userType;
    private String email;
    private String contactNumber;
    private String password;
    private String profilePicture;

}
