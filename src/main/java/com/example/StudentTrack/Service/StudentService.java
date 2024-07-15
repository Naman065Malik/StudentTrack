package com.example.StudentTrack.Service;

import java.util.List;

import com.example.StudentTrack.Model.Student;

public interface StudentService {
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
}
