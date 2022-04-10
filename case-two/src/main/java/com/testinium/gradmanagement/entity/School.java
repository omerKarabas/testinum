package com.testinium.gradmanagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="school")
public class School {
	
	@Id
	@Column(name="school_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int schoolId;
	
	@NotBlank
	@Column(name="school_name")
	@Size(min=2)
	private String schoolName;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="schoolLesson",
			joinColumns = {
					@JoinColumn(name="school_id", referencedColumnName="school_id",nullable=false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "lesson_id",referencedColumnName="lesson_id",nullable=false)
			}
		)
	private List<Lesson> lessons;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="schoolStudent",
			joinColumns = {
					@JoinColumn(name="school_id", referencedColumnName="school_id",nullable=false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "student_id",referencedColumnName="student_id",nullable=false)
			}
		)
	private List<Student> students;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="schoolExam",
			joinColumns = {
					@JoinColumn(name="school_id", referencedColumnName="school_id",nullable=false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "exam_id",referencedColumnName="exam_id",nullable=false)
			}
		)
	private List<Exam> exams;
	
	public School() {
		
	}
	
	
	public School(String schoolName, List<Lesson> lessons, List<Student> students, List<Exam> exams) {
		this.schoolName = schoolName;
		this.lessons = lessons;
		this.students = students;
		this.exams = exams;
	}


	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
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
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", lessons=" + lessons + ", students="
				+ students + ", exams=" + exams + "]";
	}
	
	
}
