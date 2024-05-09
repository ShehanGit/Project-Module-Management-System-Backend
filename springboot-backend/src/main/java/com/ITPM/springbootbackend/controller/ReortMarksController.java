package com.ITPM.springbootbackend.controller;
import com.ITPM.springbootbackend.exception.ResourseNotFoundExeption;
import com.ITPM.springbootbackend.model.Exams;
import com.ITPM.springbootbackend.model.ReportMarks;
import com.ITPM.springbootbackend.repository.ReportMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/report")
public class ReortMarksController {

    @Autowired
    private ReportMarkRepository reportRepository;

    @GetMapping
    public List<ReportMarks> getAllReportMarks() {
        return reportRepository.findAll();
    }

    //build create ReportMarks REST API
    @PostMapping
    public ReportMarks createReportMarks(@RequestBody ReportMarks reportmarks) {
        return reportRepository.save(reportmarks);
    }

    //Get by ID
    @GetMapping("{id}")
    public ResponseEntity<ReportMarks> getReportById(@PathVariable Integer id) {
        if (id > Long.MAX_VALUE || id < Long.MIN_VALUE) {
            throw new IllegalArgumentException("ID out of range for Long type");
        }

        ReportMarks reportmarks = reportRepository.findById(id.longValue()).orElseThrow(/* ... */);
        return ResponseEntity.ok(reportmarks);
    }

    //Update Exame details
    @PutMapping("{id}")
    public ResponseEntity<ReportMarks> updateReport(@PathVariable Integer id, @RequestBody ReportMarks reportDetails) {
        ReportMarks updateReport = reportRepository.findById(id.longValue()).orElseThrow(() -> new ResourseNotFoundExeption("Report not exist with id: " + id));

        updateReport.setStudentID(reportDetails.getStudentID());
        updateReport.setGroupId(reportDetails.getGroupId());
        updateReport.setStatusdocument1(reportDetails.getStatusdocument1());
        updateReport.setLogbook(reportDetails.getLogbook());
        updateReport.setProposal(reportDetails.getProposal());
        updateReport.setStatusdocument2(reportDetails.getStatusdocument2());
        updateReport.setFinalthesis(reportDetails.getFinalthesis());

        reportRepository.save(updateReport);

        return ResponseEntity.ok(updateReport);
    }

    //Delete Exam details
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteExame(@PathVariable Long id) {
        ReportMarks reportmarks = reportRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("Report not exist with id: " + id));
        reportRepository.delete(reportmarks);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}