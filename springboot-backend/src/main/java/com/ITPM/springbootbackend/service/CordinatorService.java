package com.ITPM.springbootbackend.service;

import com.ITPM.springbootbackend.dto.AssesmentRequest;
import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.exception.AssessmentUploadException;
import com.ITPM.springbootbackend.model.CordinatorAssesment;
import com.ITPM.springbootbackend.model.CordinatorPresentation;
import com.ITPM.springbootbackend.model.User;


import java.io.IOException;
import java.util.List;

public interface CordinatorService {

    User addUser(UserRequest userRequest);
    List<User> getAllUser();
    User userFindById(Long uId);

    CordinatorPresentation create(CordinatorPresentation cordinatorPresentation);

    CordinatorAssesment save(AssesmentRequest assesmentRequest) throws AssessmentUploadException;
}
