package com.ITPM.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupId;
    private String studentId;
    private String studentName;
    private Integer proposal;
    private Integer progress1;
    private Integer progress2;
    private Integer finalPresentation;
    private Integer statusDoc;
    private Integer logBook;
    private Integer proposalDocument;
    private Integer statusDoc2;
    private Integer finalThesis;
    private Integer totalMarks;
    private String passFailStatus;


    @OneToMany(mappedBy = "marks" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CommentExaminer> commentExaminers = new ArrayList<>();

    @OneToMany(mappedBy = "marks", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CommentSupervisor> commentSupervisors = new ArrayList<>();

}
