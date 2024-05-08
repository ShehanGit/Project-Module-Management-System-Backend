package com.ITPM.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Base64;

@Entity
@Data
public class CordinatorAssesment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectType;
    private String assesmentName;

    @Lob
    private byte[] assesment;

    public String getAssesmentBase64() {
        return Base64.getEncoder().encodeToString(this.assesment);
    }
}
