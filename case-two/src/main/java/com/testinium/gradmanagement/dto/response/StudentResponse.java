package com.testinium.gradmanagement.dto.response;

import java.util.List;

import com.testinium.gradmanagement.entity.Lesson;

public record StudentResponse(
		int studentId,
		String name, 
		String lastName,
		List<Lesson> lessons){

}
