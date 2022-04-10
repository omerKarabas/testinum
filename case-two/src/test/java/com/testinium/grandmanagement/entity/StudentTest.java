package com.testinium.grandmanagement.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.Student;

public class StudentTest {

	@Test
	void studentTest() {

		var newLesson = new Lesson();
		newLesson.setLessonId(0);

		var newLesson1 = new Lesson();
		newLesson1.setLessonId(1);

		List<Lesson> lessons = new ArrayList<Lesson>();
		lessons.add(newLesson);
		lessons.add(newLesson1);
		
		var newStudent = new Student();
		newStudent.setStudentId(0);
		newStudent.setName("Lorem");
		newStudent.setLastName("ipsum");
		newStudent.setLessons(lessons);

		System.out.println();

		assertEquals(0, newStudent.getStudentId());
		assertEquals("Lorem", newStudent.getName());
		assertEquals("ipsum", newStudent.getLastName());
		assertEquals(lessons, newStudent.getLessons());

	}
}
