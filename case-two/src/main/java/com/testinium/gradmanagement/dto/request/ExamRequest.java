package com.testinium.gradmanagement.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.testinium.gradmanagement.entity.ExamResult;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.SchoolYear;
import com.testinium.gradmanagement.entity.Student;

public class ExamRequest {

	@NotBlank
	private Student student;
	
	@NotBlank
	private Lesson lesson;
	
	@NotBlank
	private SchoolYear schoolYear;
	
	@Min(0) @Max(100)
	private int examScoreFirst;
	
	@Min(0) @Max(100)
	private int examScoreSecond;
	
	@NotBlank
	private ExamResult examResult;
	
	public ExamRequest() {
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public SchoolYear getSchoolYear() {
		return schoolYear;
	}


	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}


	public int getExamScoreFirst() {
		return examScoreFirst;
	}

	public void setExamScoreFirst(int examScoreFirst) {
		this.examScoreFirst = examScoreFirst;
	}

	public int getExamScoreSecond() {
		return examScoreSecond;
	}

	public void setExamScoreSecond(int examScoreSecond) {
		this.examScoreSecond = examScoreSecond;
	}

	public ExamResult getExamResult() {
		return examResult;
	}


	public void setExamResult(ExamResult examResult) {
		this.examResult = examResult;
	}

	@Override
	public String toString() {
		return "ExamRequest [student=" + student + ", lesson=" + lesson + ", schoolYear=" + schoolYear
				+ ", examScoreFirst=" + examScoreFirst + ", examScoreSecond=" + examScoreSecond + ", examResult="
				+ examResult + "]";
	}

}
