package com.ITPM.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CommentExaminer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupId;
    private String proposal;
    private String progress1;
    private String progress2;
    private String finalPresentation;

//    @ManyToOne
//    @JoinColumn(name = "marks_id")
//    @JsonBackReference
//    private Marks marks;
}
