package com.example.student.repositories;

import com.example.student.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);

    void update(Student student, Long id);
}
