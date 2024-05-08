package com.ITPM.springbootbackend.service.impl;

import com.ITPM.springbootbackend.dto.AssesmentRequest;
import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.exception.AssessmentUploadException;
import com.ITPM.springbootbackend.model.*;
import com.ITPM.springbootbackend.repository.CordinatorAssesmentRepo;
import com.ITPM.springbootbackend.repository.CordinatorPresentationRepo;
import com.ITPM.springbootbackend.repository.UserRepository;
import com.ITPM.springbootbackend.service.CordinatorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CordinatorServiceImpl implements CordinatorService {

    UserRepository userRepository;
    CordinatorPresentationRepo cordinatorPresentationRepo;
    CordinatorAssesmentRepo cordinatorAssesmentRepo;

    @Override
    public User addUser(UserRequest userRequest) {
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setUserName(userRequest.getUserName());
        user.setUserType(userRequest.getUserType());
        user.setEmail(userRequest.getEmail());
        user.setContactNumber(userRequest.getContactNumber());
        user.setPassword(userRequest.getPassword());
        user.setProfilePicture(userRequest.getProfilePicture());
        user.setName(userRequest.getName());
      return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User userFindById(Long uId) {

        Optional<User> userOptional = userRepository.findById(uId);

        if (!userOptional.isPresent()){
            return null;
        }

        User user = userOptional.get();

        return user;


    }

    @Override
    public CordinatorPresentation create(CordinatorPresentation cordinatorPresentation) {
        CordinatorPresentation cordinatorPresentation1 = new CordinatorPresentation();

        cordinatorPresentation1.setGroupId(cordinatorPresentation.getGroupId());
        cordinatorPresentation1.setTitle(cordinatorPresentation.getTitle());
        cordinatorPresentation1.setExaminer(cordinatorPresentation.getExaminer());
        cordinatorPresentation1.setDate(cordinatorPresentation.getDate());
        cordinatorPresentation1.setTime(cordinatorPresentation.getTime());

        return cordinatorPresentationRepo.save(cordinatorPresentation1);
    }



    @Override
    public CordinatorAssesment save(AssesmentRequest assessmentRequest) throws AssessmentUploadException {
        CordinatorAssesment coordinatorAssessment = new CordinatorAssesment();
        coordinatorAssessment.setProjectType(assessmentRequest.getProjectType());
        coordinatorAssessment.setAssesmentName(assessmentRequest.getAssesmentName());
        MultipartFile assessment = assessmentRequest.getAssesment();
        if (assessment != null && !assessment.isEmpty()) {
            try {
                coordinatorAssessment.setAssesment(assessment.getBytes());
            } catch (IOException e) {
                // Throw a custom exception
                throw new AssessmentUploadException("Failed to save assessment: " + e.getMessage());
            }
        }
        return cordinatorAssesmentRepo.save(coordinatorAssessment);
    }

    @Override
    public List<CordinatorPresentation> getAllPresentation() {
        return cordinatorPresentationRepo.findAll();
    }

    @Override
    public String deletePresentationById(Long presId) {

        Optional<CordinatorPresentation> sheduleOptional = cordinatorPresentationRepo.findById(presId);

        if(!sheduleOptional.isPresent()){
            return "schedule not found with id " + presId;
        }

        cordinatorPresentationRepo.deleteById(presId);

        return "presenatation schedule deleted width id " +presId;
    }

    @Override
    public List<CordinatorAssesment> getAllAssessments() {
        return cordinatorAssesmentRepo.findAll();
    }

    @Override
    public String deleteAssessmentById(Long assessmentId) {
        Optional<CordinatorAssesment> assessmentOptional = cordinatorAssesmentRepo.findById(assessmentId);

        if (!assessmentOptional.isPresent()) {
            return "Assessment not found with id " + assessmentId;
        }

        cordinatorAssesmentRepo.deleteById(assessmentId);

        return "Assessment deleted with id " + assessmentId;
    }


}
