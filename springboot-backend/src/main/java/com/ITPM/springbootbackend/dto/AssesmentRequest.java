package com.ITPM.springbootbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssesmentRequest {

    private String projectType;
    private String assesmentName;
    private MultipartFile assesment;
}
