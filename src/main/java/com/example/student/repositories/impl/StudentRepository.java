package com.example.student.repositories.impl;

import com.example.student.models.Student;
import com.example.student.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Truong", "Ha noi", 9.0f));
        students.add(new Student(2L, "Tinh", "Hai Duong", 8.0f));
        students.add(new Student(3L, "Hoang", "Nam Dinh", 7.0f));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size() - 1).getId() - 1);
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student student, Long id) {
        for (Student student1 : students) {
            if (student1.getId() == id) {
                student1.setId(student.getId());
                student1.setName(student.getName());
                student1.setAddress(student.getAddress());
                student1.setScore(student.getScore());
            }
        }
    }
}
