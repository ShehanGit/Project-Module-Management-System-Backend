package com.ITPM.springbootbackend.controller;

import com.ITPM.springbootbackend.model.Marks;
import com.ITPM.springbootbackend.service.MarksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class MarksController {

    private final MarksService marksService;

    @PostMapping("/marks")
    public Marks addMarks() {
        return marksService.addMarks();
    }

    @GetMapping("/marks/{group-id}")
    public List<Marks> marksFindByGroupId(@PathVariable("group-id") String groupId) {
        return marksService.getMarksByGroupId(groupId);
    }
}