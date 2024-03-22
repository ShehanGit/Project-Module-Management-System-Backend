package com.rpmms.rpmmsbackend.controller;

import com.rpmms.rpmmsbackend.dto.StudentDTO;
import com.rpmms.rpmmsbackend.model.LoginRequest;
import com.rpmms.rpmmsbackend.model.LoginResponse;
import com.rpmms.rpmmsbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rpmms/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/studentLogin")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        StudentDTO studentDTO = studentService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (studentDTO != null) {
            // Login successful
            LoginResponse response = new LoginResponse("Login successful", studentDTO);
            return ResponseEntity.ok(response);
        } else {
            // Login failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Invalid credentials", null));
        }
    }

    @GetMapping("/getStudents")
    public List<StudentDTO> getStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO) {

        // Check if the SLIIT ID already exists in the database
        if (studentService.existsBySliitID(studentDTO.getStudentID())) {
            return ResponseEntity.badRequest().body("SLIIT ID already exists");
        }

        // If the SLIIT ID is unique, proceed with saving the student
        studentDTO.setUserRole("student");
        studentService.saveStudent(studentDTO);
        return ResponseEntity.ok("Student saved successfully");
    }

    @PutMapping("/updateStudent")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    @DeleteMapping("/deleteStudent")
    public boolean deleteStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.deleteStudent(studentDTO);
    }

    @GetMapping("/getStudentByStudentId/{studentID}")
    public StudentDTO getStudentByStudentID(@PathVariable String studentID) {
        return studentService.getStudentByStudentID(studentID);
    }

}
