package com.example.student.services;

import com.example.student.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);

    void update(Student student, Long id);
}
