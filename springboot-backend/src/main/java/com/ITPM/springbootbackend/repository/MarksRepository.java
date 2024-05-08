package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MarksRepository extends JpaRepository<Marks, Long> {

    @Query("SELECT m FROM Marks m WHERE m.groupId = :groupId")
    List<Marks> findByGroupId(String groupId);

    Optional<Marks> findByGroupIdAndStudentId(String groupId, String studentId);
}