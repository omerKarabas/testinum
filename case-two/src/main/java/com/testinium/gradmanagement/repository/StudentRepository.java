package com.testinium.gradmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.gradmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	Student findStudentById(int studentId);
}
