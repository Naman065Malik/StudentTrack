package com.example.StudentTrack.Service;

import java.util.Map;

import com.example.StudentTrack.Model.Student;

public interface StudentService {
    Map<Long, Student> getAllStudent();
    Student getStudentById(Long id);
    Student createStudent(Long id, Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
    boolean checkIDExist(Long id);

}
