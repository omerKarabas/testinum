package com.testinium.grandmanagement.service.lesson;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.response.LessonResponse;
import com.testinium.gradmanagement.service.LessonService;

public class LessonUnitTest {

	@Autowired
	private LessonService lessonService;

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@DisplayName("get request with identity should return status ok")
	@ParameterizedTest
	@CsvFileSource(resources = "lessons.csv")
	void getLessonsByIdShouldReturnok(int lessonId, String lessonName) throws Throwable {
		
		var lessonResponse = new LessonResponse(lessonId, lessonName);
		

		Mockito.when(lessonService.findLessonById(lessonId))
				.thenReturn(lessonResponse);
		
		   mockMvc.perform(
		        	get("/lessons/"+lessonId)
		            .accept(MediaType.APPLICATION_JSON)
		        )
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.lessonId",is(lessonId)))
	        .andExpect(jsonPath("$.lessonName",is(lessonName)));

	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "lessons.csv")
	void addLessonShoulReturnok(String lessonName) throws Throwable {
		
		var lessonRequest = new LessonRequest();
		lessonRequest.setLessonName(lessonName);

		var lessonResponse = modelMapper.map(lessonRequest, LessonResponse.class);
		Mockito.when(lessonService.addLesson(lessonRequest))
				.thenReturn(lessonResponse);
		
		mockMvc.perform(
				post("/lessons")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(lessonRequest))
		)
			.andExpect(status().isOk())
	        .andExpect(jsonPath("$.lessonName",is(lessonName)));

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "lessons.csv")
	void removeLessonShoulReturnok(int lessonId, String lessonName) throws Throwable {
		
		var lessonResponse = new LessonResponse(lessonId, lessonName);
		
		Mockito.when(lessonService.removeLesson(lessonId))
				.thenReturn(lessonResponse);
		
		mockMvc.perform(
	        	delete("/lessons/"+lessonId).accept(MediaType.APPLICATION_JSON)
	        	).andExpect(status().isOk())
		        .andExpect(jsonPath("$.lessonName",is(lessonName)));

	}
	
}
