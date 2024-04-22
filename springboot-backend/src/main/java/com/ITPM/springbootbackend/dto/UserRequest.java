package com.ITPM.springbootbackend.dto;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String name;
    private String userName;
    private String userType;
    private String email;
    private String contactNumber;
    private String password;
    private String profilePicture;
}
