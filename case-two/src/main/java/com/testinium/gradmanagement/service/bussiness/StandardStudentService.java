package com.testinium.gradmanagement.service.bussiness;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.request.StudentRequest;
import com.testinium.gradmanagement.dto.response.StudentResponse;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.entity.Student;
import com.testinium.gradmanagement.repository.StudentRepository;
import com.testinium.gradmanagement.service.StudentService;

@Service
public class StandardStudentService implements StudentService {

	private StudentRepository  studentRepository; 
	private ModelMapper modelMapper;
	
	public StandardStudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
		super();
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public StudentResponse addStudent(StudentRequest studentRequest) {
		
		var addedStudent = studentRepository.save(modelMapper.map(studentRequest, Student.class));
		return modelMapper.map(addedStudent, StudentResponse.class);
	}

	@Override
	@Transactional
	public StudentResponse deleteStudentById(int studentId) {
		
		var deletedStudent = studentRepository.findStudentById(studentId);
		studentRepository.delete(deletedStudent);
		
		return modelMapper.map(deletedStudent, StudentResponse.class);
	}

	@Override
	@Transactional
	public StudentResponse updateStudentById(int studentId, StudentRequest studentRequest) {
		
		var updatedStudent =studentRepository.findStudentById(studentId);
		updatedStudent.setName(studentRequest.getName());
		updatedStudent.setName(studentRequest.getLastName());
		
		return modelMapper.map(updatedStudent, StudentResponse.class);
	}

	@Override
	public StudentResponse findStudentById(int studentId) {
		
		return modelMapper.map(studentRepository.findStudentById(studentId),StudentResponse.class); 
	}

	@Override
	public List<StudentResponse> findAllStudent() {
		
		return studentRepository.findAll()
								.stream()
								.map(student -> modelMapper.map(student, StudentResponse.class))
								.toList();
	}

	@Override
	@Transactional
	public StudentResponse addLessonToStudent(int studentId, LessonRequest lessonRequest) {
		
		var convertedLessonRequest = modelMapper.map(lessonRequest, Lesson.class);
		var studentLesson = studentRepository.findStudentById(studentId)
											 .getLessons()
											 .add(convertedLessonRequest);
		return modelMapper.map(studentLesson, StudentResponse.class);
	}

	
}

