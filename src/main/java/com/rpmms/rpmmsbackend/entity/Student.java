package com.rpmms.rpmmsbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    private String studentID;
    private String name;
    private String email;
    private String contact_number;
    private String specialization;
    private String batch;
    private String password;
    private String userRole;
}
