package com.ITPM.springbootbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "studentId")
    private String studentId;
    @Column(name = "proposal")
    private Long proposal;
    @Column(name = "progress1")
    private Long progress1;
    @Column(name = "progress2")
    private Long progress2;
    @Column(name = "finalPresentations")
    private Long finalPresentations;


}
