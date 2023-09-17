package com.example.eregistrar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;
    @Column(nullable = false)
    private String firstName;

    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;
    @Column(nullable = false)
    private String dateOFEnrollment;
    @Column(nullable = false)
    private String isInternational;
}
