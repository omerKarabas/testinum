package com.testinium.grandmanagement.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testinium.gradmanagement.entity.Lesson;

public class LessonTest {

	@Test
	void lessonTest() {
		var newLesson = new Lesson();
			newLesson.setLessonId(0);
			newLesson.setLessonName("Test");
			
			//System.out.println(newLesson.getLessonName());
		
			assertEquals(0,newLesson.getLessonId());
			assertEquals("Test", newLesson.getLessonName());
			
	}
}
