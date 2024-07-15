package com.example.StudentTrack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentTrack.DTO.StudentDTO;
import com.example.StudentTrack.Service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/Student")
    public ResponseEntity<?> getAllStudent(){
    	List<StudentDTO> response = studentService.getAllStudent();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

   @PostMapping("/Student")
   public ResponseEntity<String> createStudent(@RequestBody StudentDTO student) {
       studentService.createStudent(student);
       return new ResponseEntity<>("Student added to the database", HttpStatus.CREATED);
   }

   @GetMapping("/Student/{id}")
   public ResponseEntity<?> getStudentById(@PathVariable Long id) {
       StudentDTO response = studentService.getStudentById(id);
       if(response == null){
           return new ResponseEntity<>("Student Not Found",HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(response,HttpStatus.OK);
   }

   @PutMapping("/Student/{id}")
   public ResponseEntity<?> putUpdateStudent(@PathVariable Long id, @RequestBody StudentDTO student) {    
       StudentDTO response = studentService.updateStudent(id, student);
       return new ResponseEntity<>(response,HttpStatus.OK);
   }

   @DeleteMapping("/Student/{id}")
   public ResponseEntity<?> deleteStudent(@PathVariable Long id){
       studentService.deleteStudent(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   } 
}
