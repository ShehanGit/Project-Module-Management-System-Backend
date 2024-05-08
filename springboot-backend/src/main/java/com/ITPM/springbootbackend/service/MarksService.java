package com.ITPM.springbootbackend.service;

import com.ITPM.springbootbackend.model.Marks;

import java.util.List;

public interface MarksService {

    Marks addMarks();
    List<Marks> getMarksByGroupId(String groupId);
    Marks updateMarksByGroupId(String groupId ,String studentId,Marks updatedMarks);
}