package com.testinium.gradmanagement.dto.response;

import java.util.List;

import com.testinium.gradmanagement.entity.Exam;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.Student;

public record SchoolResponse (
		int schoolId,
		String schoolName,
		List<Lesson> lessons,
		List<Student> students,
		List<Exam> exams) {

}
