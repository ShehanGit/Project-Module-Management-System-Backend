package com.ITPM.springbootbackend.service.impl;

import com.ITPM.springbootbackend.dto.AssesmentRequest;
import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.model.CordinatorAssesment;
import com.ITPM.springbootbackend.model.CordinatorPresentation;
import com.ITPM.springbootbackend.model.User;
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
    public CordinatorAssesment save(AssesmentRequest assessmentRequest) {
        CordinatorAssesment coordinatorAssessment = new CordinatorAssesment();
        coordinatorAssessment.setProjectType(assessmentRequest.getProjectType());
        coordinatorAssessment.setAssesmentName(assessmentRequest.getAssesmentName());
        MultipartFile assessment = assessmentRequest.getAssesment();
        if (assessment != null && !assessment.isEmpty()) {
            try {
                coordinatorAssessment.setAssesment(assessment.getBytes());
            } catch (IOException e) {
                // Handle the IOException appropriately (e.g., log the error, throw a custom exception)
                e.printStackTrace();
                // You can also return null or throw a custom exception here
            }
        }
        return cordinatorAssesmentRepo.save(coordinatorAssessment);
    }


}
