package com.testinium.gradmanagement.service;

import java.util.List;

import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.request.StudentRequest;
import com.testinium.gradmanagement.dto.response.StudentResponse;

public interface StudentService {
	
	//Writeable
	StudentResponse addStudent(StudentRequest studentRequest);
	StudentResponse addLessonToStudent(int studentId, LessonRequest lessonRequest);
	StudentResponse deleteStudentById(int studentId);
	StudentResponse updateStudentById(int studentId, StudentRequest studentRequest);
	
	//Readable
	StudentResponse findStudentById(int studentId);
	List<StudentResponse> findAllStudent();
}
