package com.ITPM.springbootbackend.controller;

import com.ITPM.springbootbackend.dto.AssesmentRequest;
import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.exception.AssessmentUploadException;
import com.ITPM.springbootbackend.model.CordinatorAssesment;
import com.ITPM.springbootbackend.model.CordinatorPresentation;
import com.ITPM.springbootbackend.model.User;
import com.ITPM.springbootbackend.service.CordinatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CordinatorController {

    CordinatorService cordinatorService;



    @PostMapping("/users")
    public User addUsers(@RequestBody UserRequest userRequest){
        return cordinatorService.addUser(userRequest);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return cordinatorService.getAllUser();
    }

    @GetMapping("/users/{user-id}")
    public User getAllUsers(@PathVariable("user-id") Long uID){

        return cordinatorService.userFindById(uID);
    }

    @PostMapping("/assessment")
    public ResponseEntity<?> saveAssessment(@ModelAttribute AssesmentRequest request) throws AssessmentUploadException {
        try {
            CordinatorAssesment assessment = cordinatorService.save(request);
            return ResponseEntity.ok(assessment);
        } catch (AssessmentUploadException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/assessments")
    public List<CordinatorAssesment> getAllAssessments() {
        return cordinatorService.getAllAssessments();
    }

    @DeleteMapping("/assessments/{assessment-id}")
    public ResponseEntity<String> deleteAssessmentById(@PathVariable("assessment-id") Long assessmentId) {
        String response = cordinatorService.deleteAssessmentById(assessmentId);
        return ResponseEntity.ok(response);
    }



    @PostMapping("/presentation")
    public CordinatorPresentation createPresenation(@RequestBody CordinatorPresentation cordinatorPresentation){
        return cordinatorService.create(cordinatorPresentation);
    }

    @GetMapping("/presentations")
    public List<CordinatorPresentation> getAllPresentation(){
        return cordinatorService.getAllPresentation();
    }

    @DeleteMapping("/presentations/{presentation-id}")
    public String deletePresentationById(@PathVariable("presentation-id") Long presId){
        return cordinatorService.deletePresentationById(presId);
    }

}
