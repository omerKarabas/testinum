package com.testinium.gradmanagement.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.testinium.gradmanagement.entity.Lesson;

public class StudentRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	private List<Lesson> lessons;
	
	public StudentRequest() {
		
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
		return "StudentRequest [name=" + name + ", lastName=" + lastName + ", lessons=" + lessons + "]";
	}
	
}
