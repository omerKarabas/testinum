package com.testinium.gradmanagement.dto.request;

import javax.validation.constraints.NotBlank;

public class LessonRequest {
	
	@NotBlank
	String lessonName;
	
	public LessonRequest() {
		
	}
		
	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	@Override
	public String toString() {
		return "LessonRequest [lessonName=" + lessonName + "]";
	}

}
