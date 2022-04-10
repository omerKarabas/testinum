package com.testinium.gradmanagement.service;

import java.util.List;

import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.response.LessonResponse;

public interface LessonService {

	//Writeable 
	LessonResponse addLesson(LessonRequest lessonRequest);
	LessonResponse removeLesson(int lessonId);
	LessonResponse lessonUpdateById(int lessonId,LessonRequest lessonRequest);
	
	//Readable 
	LessonResponse findLessonById(int lessonId);
	List<LessonResponse> findAllLesson();
	
}
