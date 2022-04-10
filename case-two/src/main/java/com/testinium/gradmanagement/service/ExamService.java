package com.testinium.gradmanagement.service;

import java.util.List;

import com.testinium.gradmanagement.dto.request.ExamRequest;
import com.testinium.gradmanagement.dto.response.ExamResponse;
import com.testinium.gradmanagement.entity.SchoolYear;

public interface ExamService {

	//Writeable
	ExamResponse addExam(ExamRequest examRequest);
	ExamResponse updateExamScore(int examId,ExamRequest examRequest);
	ExamResponse removeExamById(int examId);
	
	//Readable 
	ExamResponse findExamById(int examId);
	
	//Find for student's grade average and grade process
	ExamResponse findStudentExamScoreByLesson(int studentId,int lessonId);
	List<ExamResponse> findStudentExamScoreByStudentId(int studentId);
	List<ExamResponse> findStudentExamScoreBySchoolYear(int studentId, SchoolYear schoolYear);
	
	//Find for all student's grade average and grade process
	List<ExamResponse> findAllStudentExamScoreByLesson(int lessonId);
	List<ExamResponse> findAllStudentExamScoreBySchoolYear(SchoolYear schoolyear);

}
