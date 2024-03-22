package com.rpmms.rpmmsbackend.model;

import com.rpmms.rpmmsbackend.dto.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginResponse {
    private String message;
    private StudentDTO student;
}
