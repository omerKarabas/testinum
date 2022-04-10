package com.testinium.gradmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.gradmanagement.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {

	Lesson findLessonById(int lessonId);
}
