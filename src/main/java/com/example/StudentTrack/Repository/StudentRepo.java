package com.example.StudentTrack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentTrack.Model.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{
    // Additional custom query methods can be defined here if needed
}
