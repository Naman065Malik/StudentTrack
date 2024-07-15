package com.example.StudentTrack.DTO;

public class StudentDTO {
    // private Long id;
    private String name;
    private String email;
    private String course;

    public StudentDTO() { }

    public StudentDTO(Long id, String name, String email, String course){
        // this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }

    // public void getId( Long id ) { this.id = id; }
    public void setName( String name ) { this.name = name; }
    public void setCourse( String course ) { this.course = course; }
    public void setEmail( String email ) { this.email = email; }

    @Override
    public String toString() {
        return "Student{ name='" + name + '\'' + ", email='" + email + '\'' + ", course='" + course + '\'' + '}';
    }
}
