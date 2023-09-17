package com.example.eregistrar.service;

import com.example.eregistrar.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    Student save(Student student);

    Student update(Long id, Student student);

    String deleteStudentById(Long studentId);

    List<Student> searchStudent(String keyword);
}
