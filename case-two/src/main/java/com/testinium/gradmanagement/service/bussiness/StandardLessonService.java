package com.testinium.gradmanagement.service.bussiness;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testinium.gradmanagement.dto.request.LessonRequest;
import com.testinium.gradmanagement.dto.response.LessonResponse;
import com.testinium.gradmanagement.entity.Lesson;
import com.testinium.gradmanagement.repository.LessonRepository;
import com.testinium.gradmanagement.service.LessonService;

@Service
public class StandardLessonService implements LessonService {

	private LessonRepository lessonRepository;
	private ModelMapper modelMapper;
	
	
	public StandardLessonService(LessonRepository lessonRepository, ModelMapper modelMapper) {
		super();
		this.lessonRepository = lessonRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public LessonResponse addLesson(LessonRequest lessonRequest) {
		
		var addedLesson = lessonRepository.save(
										modelMapper.map(lessonRequest, Lesson.class));
		return modelMapper.map(addedLesson, LessonResponse.class);
	}

	@Override
	@Transactional
	public LessonResponse removeLesson(int lessonId) {
		
		var findBookForDelete = lessonRepository.findLessonById(lessonId);
		lessonRepository.delete(findBookForDelete);
		
		return modelMapper.map(findBookForDelete, LessonResponse.class);
	}

	@Override
	@Transactional
	public LessonResponse lessonUpdateById(int lessonId, LessonRequest lessonRequest) {

		var managedLesson = lessonRepository.findLessonById(lessonId);
		
		managedLesson.setLessonName(lessonRequest.getLessonName());
		lessonRepository.save(managedLesson);
		
		return modelMapper.map(managedLesson, LessonResponse.class);
	}

	@Override
	public LessonResponse findLessonById(int lessonId) {
		
		return modelMapper.map(lessonRepository.findLessonById(lessonId), LessonResponse.class); 
	}

	@Override
	public List<LessonResponse> findAllLesson() {
	
		return lessonRepository.findAll()
							   .stream()
							   .map(lesson -> modelMapper.map(lesson, LessonResponse.class))
							   .toList();
	}

}
