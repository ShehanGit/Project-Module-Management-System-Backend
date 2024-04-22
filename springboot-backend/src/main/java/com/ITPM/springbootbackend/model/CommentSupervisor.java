package com.ITPM.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.yaml.snakeyaml.error.Mark;

@Entity
@Data
public class CommentSupervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupId;
    private String statusDoc1;
    private String logBook;
    private String proposalDoc;
    private String statusDoc2;
    private String finalThesis;


    @ManyToOne
    @JoinColumn(name = "marks_id")
    @JsonBackReference
    private Marks marks;
}
