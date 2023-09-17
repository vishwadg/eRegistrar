package com.example.eregistrar.repository;

import com.example.eregistrar.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsByFirstNameOrLastNameOrStudentNumber(String keyword1, String keyboard2, String keyboard3);

}
