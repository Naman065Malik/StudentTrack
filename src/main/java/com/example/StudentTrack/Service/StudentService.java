package com.example.StudentTrack.Service;

import java.util.List;

import com.example.StudentTrack.DTO.StudentDTO;

public interface StudentService {
    List<StudentDTO> getAllStudent();
    StudentDTO getStudentById(Long id);
    StudentDTO createStudent(StudentDTO student);
    StudentDTO updateStudent(Long id, StudentDTO student);
    boolean deleteStudent(Long id);
}
