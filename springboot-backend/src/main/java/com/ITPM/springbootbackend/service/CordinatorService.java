package com.ITPM.springbootbackend.service;

import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.model.User;


import java.util.List;

public interface CordinatorService {

    User addUser(UserRequest userRequest);
    List<User> getAllUser();
    User userFindById(Long uId);
}
