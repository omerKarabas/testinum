package com.testinium.grandmanagement.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testinium.gradmanagement.entity.Exam;
import com.testinium.gradmanagement.entity.ExamResult;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.SchoolYear;
import com.testinium.gradmanagement.entity.Student;

public class ExamTest {

	@Test
	void lessonTest() {
		
		var newStudent =  new Student ();
			newStudent.setStudentId(1);
		
		var newLesson = new Lesson();
			newLesson.setLessonId(1);
	
			var newExam = new Exam();
			newExam.setExamId(0);
			newExam.setStudent(newStudent);
			newExam.setLesson(newLesson);
			newExam.setSchoolYear(SchoolYear.ACTIVE2122); 
			newExam.setExamScoreFirst(50);
			newExam.setExamScoreSecond(60); 
			newExam.setExamResult(ExamResult.SUCCCES);
			 
			//System.out.println(newExam.getExamResult());
			
			assertEquals(0, newExam.getExamId());
			assertEquals(1, newExam.getStudent().getStudentId());
			assertEquals(1, newExam.getLesson().getLessonId());
			assertEquals("ACTIVE2122", newExam.getSchoolYear().toString());
			assertEquals(50, newExam.getExamScoreFirst());
			assertEquals(60, newExam.getExamScoreSecond());
			assertEquals("SUCCCES", newExam.getExamResult().toString());

			
	}
}
