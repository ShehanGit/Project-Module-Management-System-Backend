package com.rpmms.rpmmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String studentID;
    private String name;
    private String email;
    private String contact_number;
    private String specialization;
    private String batch;
    private String password;
    private String userRole;
}
