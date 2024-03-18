package com.ITPM.springbootbackend.controller;

import com.ITPM.springbootbackend.exception.ResourseNotFoundExeption;
import com.ITPM.springbootbackend.model.PresentationShedule;
import com.ITPM.springbootbackend.repository.ExamRepository;
import com.ITPM.springbootbackend.repository.PresentationSheduleRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/presentationshedule")
public class PresentatinSheduleController {

    @Autowired
    private PresentationSheduleRepository PresentationShedule;


    @GetMapping
    public List<PresentationShedule> getAllEmployees() {
        return PresentationShedule.findAll(); // Notice the lowercase 'p'
    }






    //build create PresentationShedule REST API
    @PostMapping
    public PresentationShedule createPresentationShedule(@RequestBody PresentationShedule PresentShedule) {
        return PresentationShedule.save(PresentShedule);
    }

    //Get by ID
    @GetMapping("{id}")
    public ResponseEntity<PresentationShedule> getExameById(@PathVariable Integer id) {
        if (id > Long.MAX_VALUE || id < Long.MIN_VALUE) {
            throw new IllegalArgumentException("ID out of range for Long type");
        }

        PresentationShedule exams = PresentationShedule.findById(id.longValue()).orElseThrow(/* ... */);
        return ResponseEntity.ok(exams);
    }

    //Update Exame details
    @PutMapping("{id}")
    public ResponseEntity<PresentationShedule> updatePresentatationshadule1e(@PathVariable Integer id, @RequestBody PresentationShedule examDetails) {
        PresentationShedule updatePresentatationshadule1 = PresentationShedule.findById(id.longValue()).orElseThrow(() -> new ResourseNotFoundExeption("Exam not exist with id: " + id));

        updatePresentatationshadule1.setProjectgroup(examDetails.getProjectgroup());
        updatePresentatationshadule1.setTital(examDetails.getTital());
        updatePresentatationshadule1.setDate(examDetails.getDate());
        updatePresentatationshadule1.setTime(examDetails.getTime());
        updatePresentatationshadule1.setVenue(examDetails.getVenue());
        updatePresentatationshadule1.setExaminar1(examDetails.getExaminar1());
        updatePresentatationshadule1.setExaminar2(examDetails.getExaminar2());
        updatePresentatationshadule1.setExaminar3(examDetails.getExaminar3());


//        private Long ID;
//        private String projectgroup;
//        private Long tital;
//        private Long date;
//        private Long time;
//        private String venue;
//        private Long examinar1;
//        private Long examinar2;
//        private Long examinar3;


        PresentationShedule.save(updatePresentatationshadule1);

        return ResponseEntity.ok(updatePresentatationshadule1);
    }

    //Delete Exam details
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteExame(@PathVariable Long id) {
        PresentationShedule exams = PresentationShedule.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("Exam not exist with id: " + id));
        PresentationShedule.delete(exams);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }