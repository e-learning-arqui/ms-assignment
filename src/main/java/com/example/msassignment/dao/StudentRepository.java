package com.example.msassignment.dao;

import com.example.msassignment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByKeycloakId (String keycloakId);
}
