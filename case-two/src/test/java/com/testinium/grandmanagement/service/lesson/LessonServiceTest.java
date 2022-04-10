package com.testinium.grandmanagement.service.lesson;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import com.testinium.gradmanagement.app.CaseTwoApplication;
import com.testinium.gradmanagement.dto.response.LessonResponse;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.service.LessonService;

@SpringBootTest(
		classes = CaseTwoApplication.class,
		webEnvironment = WebEnvironment.MOCK
	)
@AutoConfigureMockMvc
class LessonServiceTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	LessonService lessonService;
	
	@DisplayName("get request with identity should return status ok")
	@ParameterizedTest
	@CsvFileSource(resources = "lessons.csv")
	void findLessonByIdentityShoudlReturnOk(int lessonId,String lessonName) throws Throwable {
		// 1. Test Setup
		var lesson1 = new Lesson();
		lesson1.setLessonId(lessonId);
		lesson1.setLessonName(lessonName);
		
		System.err.println(lesson1);
		 var lessonResponse = modelMapper.map(lesson1, LessonResponse.class);
		
		Mockito.when(lessonService.findLessonById(lessonId))
		 			.thenReturn(lessonResponse);
		
		// 2. Call exercise method
		mockMvc.perform(get("/lessons/"+lessonId).accept(MediaType.APPLICATION_JSON))
		 // 3. Verification
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.lessonId",is(lessonId)))
        .andExpect(jsonPath("$.lessonName",is(lessonName)));
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "lessons.csv")
	void removeLessonByIdentityShoudlReturnOk(int lessonId, String lessonName) throws Throwable {
		// 1. Test Setup
		var lesson1 = new Lesson();
		lesson1.setLessonId(lessonId);
		lesson1.setLessonName(lessonName);
		
		var lessonResponse = modelMapper.map(lesson1, LessonResponse.class);
		Mockito.when(lessonService.removeLesson(lessonId))
		       .thenReturn(lessonResponse);
		// 2. Call exercise method
        mockMvc.perform(
        	delete("/lessons/"+lessonId).accept(MediaType.APPLICATION_JSON)
        )
        // 3. Verification
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.lessonId",is(lessonId)))
        .andExpect(jsonPath("$.fullname",is(lessonName)));
		// 4. Tear-down
	}
}
