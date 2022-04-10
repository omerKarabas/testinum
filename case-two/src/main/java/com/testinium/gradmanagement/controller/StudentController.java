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
import com.testinium.gradmanagement.dto.request.StudentRequest;
import com.testinium.gradmanagement.dto.response.StudentResponse;
import com.testinium.gradmanagement.service.StudentService;

@RestController
@RequestScope
@RequestMapping("/students")
@CrossOrigin
@Validated
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public StudentResponse addStudent( @RequestBody StudentRequest studentRequest) {
		return studentService.addStudent(studentRequest);
	}
	
	@PostMapping
	public StudentResponse addLessonToStudent(@PathVariable int studentId, @RequestBody LessonRequest lessonRequest){
		return studentService.addLessonToStudent(studentId, lessonRequest);
	}
	
	@DeleteMapping("{studentId}")
	public StudentResponse deleteStudentById(@PathVariable int studentId) {
		return studentService.deleteStudentById(studentId);
	}
	
	@PutMapping("{studentId}")
	public StudentResponse updateStudentById(@PathVariable int studentId, @RequestBody StudentRequest studentRequest) {
		return studentService.updateStudentById(studentId, studentRequest);
	}
	
	@GetMapping("{studentId}")
	public StudentResponse findStudentById(@PathVariable int studentId) {
		return studentService.findStudentById(studentId);
	}
	
	@GetMapping
	public List<StudentResponse> findAllStudent(){
		return studentService.findAllStudent();
	}
}
