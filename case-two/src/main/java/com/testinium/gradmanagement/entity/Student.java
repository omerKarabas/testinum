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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	@Column(name = "name")
	@Size(min=3)
	private String name;
	
	@Column(name = "last_name")
	@Size(min=2)
	private String lastName;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="studentLesson",
			joinColumns = {
					@JoinColumn(name="student_id", referencedColumnName="student_id",nullable=false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "lesson_id",referencedColumnName="lesson_id",nullable=false)
			}
		)
	private List<Lesson> lessons;
	
	public Student () {
		
	}

	public Student(@Size(min = 3) String name, @Size(min = 2) String lastName, List<Lesson> lessons) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.lessons = lessons;
	}



	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", lastName=" + lastName + ", lessons=" + lessons
				+ "]";
	}


}
