package com.example.eregistrar.service.impl;

import com.example.eregistrar.entity.Student;
import com.example.eregistrar.repository.StudentRepository;
import com.example.eregistrar.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student save(Student student) {
        if (student != null) {
            studentRepository.save(student);
            System.out.println("Student saved with first name: " + student.getFirstName());
        }
        return student;
    }

    @Override
    public Student update(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setMiddleName(student.getMiddleName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setCgpa(student.getCgpa());
            existingStudent.setIsInternational(student.getIsInternational());
            existingStudent.setCgpa(student.getCgpa());

            studentRepository.save(existingStudent);
        }
        return existingStudent;
    }

    @Override
    public String deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }

    @Override
    public List<Student> searchStudent(String keyword) {
        if (keyword != null) {
            return studentRepository.findStudentsByFirstNameOrLastNameOrStudentNumber(keyword, keyword, keyword);
        }
        return null;
    }
}
