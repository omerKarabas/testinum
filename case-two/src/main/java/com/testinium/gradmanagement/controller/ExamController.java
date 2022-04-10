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

import com.testinium.gradmanagement.dto.request.ExamRequest;
import com.testinium.gradmanagement.dto.response.ExamResponse;
import com.testinium.gradmanagement.entity.SchoolYear;
import com.testinium.gradmanagement.service.ExamService;

@RestController
@RequestScope
@RequestMapping("/exams")
@CrossOrigin
@Validated
public class ExamController {

	private ExamService examService;

	public ExamController(ExamService examService) {
		super();
		this.examService = examService;
	}
	
	@PostMapping
	public ExamResponse addExam(@RequestBody ExamRequest examRequest) {
		return examService.addExam(examRequest);
	}
	
	@PutMapping("{examId}")
	public ExamResponse updateExamScore(@PathVariable int examId,@RequestBody ExamRequest examRequest) {
		return examService.updateExamScore(examId, examRequest);
	}
	
	@DeleteMapping("{examId}")
	public ExamResponse removeExamById(@PathVariable int examId) {
		return examService.removeExamById(examId);
	}
	
	@GetMapping("{examId}")
	public ExamResponse findExamById(@PathVariable int examId) {
		return examService.findExamById(examId);
	}
	
	@GetMapping
	public ExamResponse findStudentExamScoreByLesson(@PathVariable int studentId, @PathVariable int lessonId) {
		return examService.findStudentExamScoreByLesson(studentId, lessonId);
	}
	
	@GetMapping
	public List<ExamResponse> findStudentExamScoreByStudentId(@PathVariable int studentId) {
		return examService.findStudentExamScoreByStudentId(studentId);
	}
	
	@GetMapping
	public List<ExamResponse> findStudentExamScoreBySchoolYear( @PathVariable int studentId,  @PathVariable SchoolYear schoolYear) {
		return examService.findStudentExamScoreBySchoolYear(studentId, schoolYear);
	}
	
	@GetMapping
	public List<ExamResponse> findAllStudentExamScoreByLesson(@PathVariable int lessonId){
		return examService.findAllStudentExamScoreByLesson(lessonId);
	}
	
	@GetMapping
	public List<ExamResponse> findAllStudentExamScoreBySchoolYear(@PathVariable SchoolYear schoolyear){
		return examService.findAllStudentExamScoreBySchoolYear(schoolyear);
	}
}
