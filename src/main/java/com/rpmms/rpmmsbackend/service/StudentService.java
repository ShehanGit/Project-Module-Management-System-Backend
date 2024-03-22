package com.rpmms.rpmmsbackend.service;

import com.rpmms.rpmmsbackend.dto.StudentDTO;

import com.rpmms.rpmmsbackend.entity.Student;
import com.rpmms.rpmmsbackend.repo.StudentRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
        return studentDTO;
    }

    public boolean existsBySliitID(String sliitID) {
        return studentRepo.existsByStudentID(sliitID);
    }

    public StudentDTO login(String studentID, String password) {
        Student student = studentRepo.findByStudentID(studentID);
        if (student != null && student.getPassword().equals(password)) {
            // You might want to handle password encryption and validation here
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepo.findAll();
        return modelMapper.map(studentList, new TypeToken<List<StudentDTO>>() {
        }.getType());
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
        return studentDTO;
    }

    public boolean deleteStudent(StudentDTO studentDTO) {
        studentRepo.delete(modelMapper.map(studentDTO, Student.class));
        return true;
    }

    // student id > student details
    // select * from student where id = 2
    public StudentDTO getStudentByStudentID(String studentID) {
        Student student = studentRepo.getStudentByStudentID(studentID);
        return modelMapper.map(student, StudentDTO.class);
    }

}
