package com.testinium.gradmanagement.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.testinium.gradmanagement.entity.Exam;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.Student;

public class SchoolRequest {
	
	@NotBlank
	private String schoolName;
	
	@NotBlank
	private List<Lesson> lessons;
	
	@NotBlank
	private List<Student> students;
	
	@NotBlank
	private List<Exam> exams;
	
	public SchoolRequest() {
		
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "SchoolRequest [schoolName=" + schoolName + ", lessons=" + lessons + ", students=" + students
				+ ", exams=" + exams + "]";
	}
	
	
}
