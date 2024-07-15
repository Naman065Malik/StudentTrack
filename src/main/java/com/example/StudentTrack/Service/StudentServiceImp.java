package com.example.StudentTrack.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentTrack.DTO.StudentDTO;
import com.example.StudentTrack.Model.Student;
import com.example.StudentTrack.Repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> response = studentRepo.findAll();
        return response
        .stream().map(this::studentToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> response = studentRepo.findById(id);

        // return response.orElseThrow(() -> new RuntimeException("Resourcxe not Found"));
        Student responseStudent = response.orElseThrow(() -> new IllegalArgumentException("Resource Not Found " + id));
        return studentToDTO(responseStudent);
    }

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        Student temp = dtoToStudent(student);
        Student response = studentRepo.save(temp);
        return studentToDTO(response);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO student) {
        Student response = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Resource Not Found " + id));
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setCourse(student.getCourse());
        Student responseStudent = studentRepo.save(response);
        return studentToDTO(responseStudent);
    }

    @Override
    public boolean deleteStudent(Long id) {
        Student temp = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Resource Not Found " + id));
        studentRepo.delete(temp);
        return true;
    }

    public StudentDTO studentToDTO(Student student){
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getCourse());
    }

    public Student dtoToStudent(StudentDTO student){
        return new Student(student.getName(), student.getEmail(), student.getCourse());
    }

}
