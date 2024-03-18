package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.Exams;
import com.ITPM.springbootbackend.model.PresentationShedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PresentationSheduleRepository extends JpaRepository<PresentationShedule, Long> {


}
