package com.example.StudentTrack;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.StudentTrack.Model.Student;

@SpringBootApplication
public class StudentTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentTrackApplication.class, args);
	}

	@Bean
    public Map<Long, Student> studentRepo() {
        return new HashMap<>();
    }

}
