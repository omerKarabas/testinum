package com.testinium.gradmanagement.service.bussiness;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testinium.gradmanagement.dto.request.ExamRequest;
import com.testinium.gradmanagement.dto.response.ExamResponse;
import com.testinium.gradmanagement.entity.Exam;
import com.testinium.gradmanagement.entity.SchoolYear;
import com.testinium.gradmanagement.repository.ExamRepository;
import com.testinium.gradmanagement.service.ExamService;

@Service
public class StandardExamService implements ExamService {

	private ExamRepository examRepository;
	private ModelMapper modelMapper;
	
	
	public StandardExamService(ExamRepository examRepository, ModelMapper modelMapper) {
		super();
		this.examRepository = examRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public ExamResponse addExam(ExamRequest examRequest) {
		
		var addedExam = examRepository.save(modelMapper.map(examRequest, Exam.class)); 
		return modelMapper.map(addedExam, ExamResponse.class);
	}

	@Override
	@Transactional
	public ExamResponse updateExamScore(int examId, ExamRequest examRequest) {
		
		var updatedExam = examRepository.findExamById(examId);
		
		updatedExam.setExamScoreFirst(examRequest.getExamScoreFirst());
		updatedExam.setExamScoreSecond(examRequest.getExamScoreSecond());
		examRepository.save(updatedExam);
		
		return modelMapper.map(updatedExam, ExamResponse.class);
	}

	@Override
	@Transactional
	public ExamResponse removeExamById(int examId) {
		 
		var deletedExam = examRepository.findExamById(examId);
		examRepository.delete(deletedExam);
		
		return modelMapper.map(deletedExam, ExamResponse.class);
	}


	@Override
	public ExamResponse findExamById(int examId) {
		
		return modelMapper.map(examRepository.findExamById(examId), ExamResponse.class);
	}

	@Override
	public ExamResponse findStudentExamScoreByLesson(int studentId, int lessonId) {
		
		/*if student id and lesson id is equal request value, we can use this exam id because 
		 *exam id is uniq for table also if i know exam id, i can use every exam information*/  
		
		var examByLesson = examRepository.findAll()
										  .stream()
										  .filter(student -> student.getStudent().getStudentId()==studentId)
										  .filter(lesson -> lesson.getLesson().getLessonId() == lessonId)
										  .map(exam -> exam.getExamId())
										  .map(examId -> modelMapper.map(examId, ExamResponse.class));
		
		var convertedExam = modelMapper.map(examByLesson, Exam.class);
		var findExam = examRepository.findExamById(convertedExam.getExamId());
		
		return modelMapper.map(findExam, ExamResponse.class);
	}

	@Override
	public List<ExamResponse> findStudentExamScoreByStudentId(int studentId) {
		
		return  examRepository.findAll()
							  .stream()
							  .filter(student -> student.getStudent().getStudentId() == studentId)
							  .map(findExam -> examRepository.findExamById(findExam.getExamId()))
							  .map(exam -> modelMapper.map(exam, ExamResponse.class))
							  .toList();		
		
	}

	@Override
	public List<ExamResponse> findStudentExamScoreBySchoolYear(int studentId, SchoolYear schoolYear) {
		
		return  examRepository.findAll()
							  .stream()
							  .filter(student -> student.getStudent().getStudentId() == studentId)
							  .filter(filterSchoolYear -> filterSchoolYear.getSchoolYear() == schoolYear)
							  .map(findExam -> examRepository.findExamById(findExam.getExamId()))
							  .map(exam -> modelMapper.map(exam, ExamResponse.class))
							  .toList();	
	}

	@Override
	public List<ExamResponse> findAllStudentExamScoreByLesson(int lessonId) {
		
		return examRepository.findAll()
							 .stream()
							 .filter(lesson -> lesson.getLesson().getLessonId() == lessonId)
							 .map(exam -> modelMapper.map(exam, ExamResponse.class))
							 .toList();
	}

	@Override
	public List<ExamResponse> findAllStudentExamScoreBySchoolYear(SchoolYear schoolyear) {
		
		return examRepository.findAll()
				 .stream()
				 .filter(filterSchoolYear -> filterSchoolYear.getSchoolYear() == schoolyear)
				 .map(exam -> modelMapper.map(exam, ExamResponse.class))
				 .toList();
	}

}
