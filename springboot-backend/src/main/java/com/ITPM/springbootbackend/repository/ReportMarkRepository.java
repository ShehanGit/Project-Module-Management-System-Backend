package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.ReportMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportMarkRepository extends JpaRepository<ReportMarks, Long> {
}
