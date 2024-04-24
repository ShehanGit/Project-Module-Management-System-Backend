package com.ITPM.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Entity
@Data
@Table(name = "c_presentation")
public class CordinatorPresentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupId;
    private String title;
    private String examiner;
    private LocalDate date;
    private LocalTime time;

}
