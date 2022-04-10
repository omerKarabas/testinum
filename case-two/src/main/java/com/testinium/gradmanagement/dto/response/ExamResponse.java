package com.testinium.gradmanagement.dto.response;

import com.testinium.gradmanagement.entity.ExamResult;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.SchoolYear;
import com.testinium.gradmanagement.entity.Student;

public record ExamResponse(
		int examId,
		Student student,
		Lesson lesson,
		SchoolYear schoolYear,
		int examScoreFirst,
		int examScoreSecond,
		int average,
		ExamResult examResult) {
}
