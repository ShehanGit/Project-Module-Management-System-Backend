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
@Table(name = "reportmarks")
public class ReportMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "groupId")
    private String groupId;

    @Column(name = "statusdocument1")
    private Long statusdocument1;

    @Column(name = "logbook")
    private Long logbook;

    @Column(name = "proposal")
    private Long proposal;

    @Column(name = "statusdocument2")
    private Long statusdocument2;

    @Column(name = "finalthesis")
    private Long finalthesis;


}
