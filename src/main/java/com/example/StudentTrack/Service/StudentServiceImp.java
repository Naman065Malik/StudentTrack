package com.example.StudentTrack.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentTrack.Model.Student;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private Map<Long,Student> studentRepo;

    @Override
    public Map<Long, Student> getAllStudent() {
        return studentRepo;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.get(id);
    }

    @Override
    public Student createStudent(Long id, Student student) {
        studentRepo.put(id, student);
        return studentRepo.get(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        studentRepo.put(id, student);
        return studentRepo.get(id);
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepo.remove(id);
        return true;
    }

    @Override
    public boolean checkIDExist(Long id) {
        Student student = studentRepo.get(id);
        return !(student == null);
    }
}
