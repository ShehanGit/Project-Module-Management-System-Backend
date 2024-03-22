package com.rpmms.rpmmsbackend.repo;

import com.rpmms.rpmmsbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM STUDENT WHERE STUDENTID = ?1", nativeQuery = true)
    Student getStudentByStudentID(String studentId);

    boolean existsByStudentID(String studentID);

    Student findByStudentID(String studentID);
}
