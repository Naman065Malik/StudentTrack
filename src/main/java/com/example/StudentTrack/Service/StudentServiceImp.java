package com.example.StudentTrack.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentTrack.Model.Student;
import com.example.StudentTrack.Repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> response = studentRepo.findById(id);

        // return response.orElseThrow(() -> new RuntimeException("Resourcxe not Found"));
        return response.orElseThrow(() -> new IllegalArgumentException("Resource Not Found " + id));
    }

    @Override
    public Student createStudent(Student student) {
        Student response = studentRepo.save(student);
        return response;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student temp = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Resource Not Found " + id));
        temp.setName(student.getName());
        temp.setEmail(student.getEmail());
        temp.setCourse(student.getCourse());
        return studentRepo.save(temp);
    }

    @Override
    public boolean deleteStudent(Long id) {
        Student temp = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Resource Not Found " + id));
        studentRepo.delete(temp);
        return true;
    }

}
