package com.ITPM.springbootbackend.controller;

import com.ITPM.springbootbackend.exception.ResourseNotFoundExeption;
import com.ITPM.springbootbackend.model.Exams;
import com.ITPM.springbootbackend.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping
    public List<Exams> getAllEmployees() {
        return examRepository.findAll();
    }

    //build create Exams REST API
    @PostMapping
    public Exams createExams(@RequestBody Exams exams) {
        return examRepository.save(exams);
    }

    //Get by ID
    @GetMapping("{id}")
    public ResponseEntity<Exams> getExameById(@PathVariable Integer id) {
        if (id > Long.MAX_VALUE || id < Long.MIN_VALUE) {
            throw new IllegalArgumentException("ID out of range for Long type");
        }

        Exams exams = examRepository.findById(id.longValue()).orElseThrow(/* ... */);
        return ResponseEntity.ok(exams);
    }

    //Update Exame details
    @PutMapping("{id}")
    public ResponseEntity<Exams> updateExame(@PathVariable Integer id, @RequestBody Exams examDetails) {
        Exams updateExam = examRepository.findById(id.longValue()).orElseThrow(() -> new ResourseNotFoundExeption("Exam not exist with id: " + id));

        updateExam.setName(examDetails.getName());
        updateExam.setStudentId(examDetails.getStudentId());
        updateExam.setProposal(examDetails.getProposal());
        updateExam.setProgress1(examDetails.getProgress1());
        updateExam.setProgress2(examDetails.getProgress2());
        updateExam.setFinalPresentations(examDetails.getFinalPresentations());

        //studentId
        examRepository.save(updateExam);

        return ResponseEntity.ok(updateExam);
    }

    //Delete Exam details
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteExame(@PathVariable Long id) {
        Exams exams = examRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("Exam not exist with id: " + id));
        examRepository.delete(exams);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }