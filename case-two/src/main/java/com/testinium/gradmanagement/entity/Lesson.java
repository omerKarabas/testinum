package com.testinium.gradmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lessons")
public class Lesson {

	@Id
	@Column(name = "lesson_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lessonId;
	
	@NotBlank
	@Column(name = "lesson_name")
	@Size(min=5)
	private String lessonName;
	
	
	public Lesson() {

	}
	
	public Lesson(String lessonName) {
		super();
		this.lessonName = lessonName;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	@Override
	public String toString() {
		return "Lesson [lessonId=" + lessonId + ", lessonName=" + lessonName + "]";
	}



	
	
	
	

}
