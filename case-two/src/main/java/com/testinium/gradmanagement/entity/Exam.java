package com.testinium.gradmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="exams")
public class Exam {
	
	@Id
	@Column(name="exam_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int examId;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name="lesson_id")
	private Lesson lesson;
	
	@NotBlank
	@Column(name="school_year")
	@Enumerated
	private SchoolYear schoolYear;
	
	@NotBlank
	@Min(0) 
	@Max(100)
	@Column(name="exam_score_first")
	private int examScoreFirst;
	
	@NotBlank
	@Min(0) 
	@Max(100)
	@Column(name="exam_score_second")
	private int examScoreSecond;
	
	
	@Min(0) 
	@Max(100)
	@Column(name="average")
	private int average = (examScoreFirst + examScoreSecond)/2;
	
	@Column(name="exam_result")
	@Enumerated
	private ExamResult examResult;

	public Exam () {
		
	}
	
	public Exam(Student student, Lesson lesson, SchoolYear schoolYear, int examScoreFirst, int examScoreSecond,
			ExamResult examResult) {
		super();
		this.student = student;
		this.lesson = lesson;
		this.schoolYear = schoolYear;
		this.examScoreFirst = examScoreFirst;
		this.examScoreSecond = examScoreSecond;
		this.examResult = examResult;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public SchoolYear getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public ExamResult getExamResult() {
		return examResult;
	}

	public void setExamResult(ExamResult examResult) {
		this.examResult = examResult;
	}

	@Override
	public String toString() {
		return "Exam [student=" + student + ", lesson=" + lesson + ", schoolYear=" + schoolYear + ", examScoreFirst="
				+ examScoreFirst + ", examScoreSecond=" + examScoreSecond + ", average=" + average + ", examResult="
				+ examResult + "]";
	}

}
