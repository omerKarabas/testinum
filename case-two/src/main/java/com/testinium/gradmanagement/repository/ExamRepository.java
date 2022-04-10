package com.testinium.gradmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.gradmanagement.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam,Integer> {

	Exam findExamById (int examId);
}
