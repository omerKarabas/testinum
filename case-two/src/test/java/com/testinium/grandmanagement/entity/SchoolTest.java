package com.testinium.grandmanagement.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.testinium.gradmanagement.entity.Exam;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.School;
import com.testinium.gradmanagement.entity.Student;

public class SchoolTest {

	@Test
	void schoolTest() {
		var newStudent = new Student();
			newStudent.setStudentId(0);

		var newStudent1 = new Student();
			newStudent1.setStudentId(1);

		List<Student> students = new ArrayList<Student>();
			students.add(0, newStudent); 
			students.add(1, newStudent); 

		var newLesson = new Lesson();
			newLesson.setLessonId(0);

		var newLesson1 = new Lesson();
			newLesson1.setLessonId(1);

		List<Lesson> lessons = new ArrayList<Lesson>();
			lessons.add(newLesson);
			lessons.add(newLesson1);

		var newExam = new Exam();
			newExam.setExamId(0);

		var newExam1 = new Exam();
			newExam1.setExamId(1);

		List<Exam> exams = new ArrayList<Exam>();
			exams.add(newExam);
			exams.add(newExam1);

		var newSchool = new School();
			newSchool.setSchoolId(0);
			newSchool.setSchoolName("Lorem İpsum");
			newSchool.setStudents(students);
			newSchool.setLessons(lessons);
			newSchool.setExams(exams);
		
		//System.out.println(newSchool.getExams());

		assertEquals(0, newSchool.getSchoolId());
		assertEquals(students, newSchool.getStudents());
		assertEquals(lessons, newSchool.getLessons());
		assertEquals(exams, newSchool.getExams());

	}
}
