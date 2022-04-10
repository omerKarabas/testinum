package com.testinium.gradmanagement.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.testinium.gradmanagement.dto.request.ExamRequest;
import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.request.SchoolRequest;
import com.testinium.gradmanagement.dto.request.StudentRequest;
import com.testinium.gradmanagement.dto.response.ExamResponse;
import com.testinium.gradmanagement.dto.response.LessonResponse;
import com.testinium.gradmanagement.dto.response.SchoolResponse;
import com.testinium.gradmanagement.dto.response.StudentResponse;
import com.testinium.gradmanagement.entity.Exam;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.School;
import com.testinium.gradmanagement.entity.Student;

@Configuration
public class ModelMapperConfig {

	private static final Converter <Lesson, LessonResponse> 
			LESSON_TO_LESSON_RESPONSE_CONVERTER =
				context -> new LessonResponse(
						context.getSource().getLessonId(), 
						context.getSource().getLessonName()); 
	
	private static final Converter<LessonRequest, Lesson>
			LESSON_REQUEST_TO_LESSON_CONVERTER =
				context -> new Lesson(
						context.getSource().getLessonName());
	
	private static final Converter<School, SchoolResponse>
			SCHOOL_TO_SCHOOL_RESPONSE_CONVERTER = 
				context -> new SchoolResponse(
						context.getSource().getSchoolId(),
						context.getSource().getSchoolName(),
						context.getSource().getLessons(),
						context.getSource().getStudents(),
						context.getSource().getExams());
	
	private static final Converter<SchoolRequest, School> 
			SCHOOL_REQUEST_TO_SCHOOL_CONVERTER =
				context -> new School(
						context.getSource().getSchoolName(),
						context.getSource().getLessons(),
						context.getSource().getStudents(),
						context.getSource().getExams());
				
	private static final Converter<Student,StudentResponse> 
			STUDENT_TO_STUDENT_RESPONSE_CONVERTER =
				context -> new StudentResponse (
						context.getSource().getStudentId(),
						context.getSource().getName(),
						context.getSource().getLastName(),
						context.getSource().getLessons());
				
	private static final Converter<StudentRequest, Student>
		  	STUDENT_REQUEST_TO_SCHOOL_CONVERTER =
		  		context -> new Student(
		  				context.getSource().getName(),
						context.getSource().getLastName(),
						context.getSource().getLessons());
		  		
	private static final Converter<Exam,ExamResponse>
			EXAM_TO_EXAM_RESPONSE_CONVERTER =
				context -> new ExamResponse(
						context.getSource().getExamId(),
						context.getSource().getStudent(),
						context.getSource().getLesson(),
						context.getSource().getSchoolYear(),
						context.getSource().getExamScoreFirst(),
						context.getSource().getExamScoreSecond(),
						context.getSource().getAverage(),
						context.getSource().getExamResult());
				
	private static final Converter<ExamRequest,Exam> 
			EXAM_REQUEST_TO_EXAM_CONVERTER =
				context -> new Exam(
						context.getSource().getStudent(),
						context.getSource().getLesson(),
						context.getSource().getSchoolYear(),
						context.getSource().getExamScoreFirst(),
						context.getSource().getExamScoreSecond(),
						context.getSource().getExamResult());
				
	@Bean("standardModelMapper") 
	ModelMapper createModelMapper() {
		var modelMapper = new ModelMapper(); 
		
		modelMapper.addConverter(LESSON_TO_LESSON_RESPONSE_CONVERTER,Lesson.class, LessonResponse.class);
		modelMapper.addConverter(LESSON_REQUEST_TO_LESSON_CONVERTER,LessonRequest.class, Lesson.class);
		
		modelMapper.addConverter(SCHOOL_TO_SCHOOL_RESPONSE_CONVERTER,School.class, SchoolResponse.class);
		modelMapper.addConverter(SCHOOL_REQUEST_TO_SCHOOL_CONVERTER,SchoolRequest.class, School.class);
		
		modelMapper.addConverter(STUDENT_TO_STUDENT_RESPONSE_CONVERTER,Student.class, StudentResponse.class);
		modelMapper.addConverter(STUDENT_REQUEST_TO_SCHOOL_CONVERTER,StudentRequest.class, Student.class);
		
		modelMapper.addConverter(EXAM_TO_EXAM_RESPONSE_CONVERTER,Exam.class, ExamResponse.class);
		modelMapper.addConverter(EXAM_REQUEST_TO_EXAM_CONVERTER,ExamRequest.class, Exam.class);
		
		return modelMapper;
	}
}
