package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.Exams;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamRepository extends JpaRepository<Exams, Long> {


}
