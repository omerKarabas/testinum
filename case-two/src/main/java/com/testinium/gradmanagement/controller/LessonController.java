package com.testinium.gradmanagement.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.response.LessonResponse;
import com.testinium.gradmanagement.service.LessonService;

@RestController
@RequestScope
@RequestMapping("/lessons")
@CrossOrigin
@Validated
public class LessonController {

	private LessonService  lessonService;

	public LessonController(LessonService lessonService) {
		super();
		this.lessonService = lessonService;
	}
	
	@PostMapping
	public LessonResponse addLesson(@RequestBody LessonRequest lessonRequest) {
		return lessonService.addLesson(lessonRequest);
	}
	
	@DeleteMapping("{lessonId}")
	public LessonResponse removeLesson(@PathVariable int lessonId) {
		return lessonService.removeLesson(lessonId);
	}
	
	@PutMapping("{lessonId}")
	public LessonResponse lessonUpdateById(@PathVariable int lessonId, @RequestBody LessonRequest lessonRequest) {
		return lessonService.lessonUpdateById(lessonId, lessonRequest);
	}
	
	@GetMapping("{lessonId}")
	public LessonResponse findLessonById(int lessonId) {
		return lessonService.findLessonById(lessonId);
	}
	
	@GetMapping
	public List<LessonResponse> findAllLesson(){
		return lessonService.findAllLesson();
	}
}
