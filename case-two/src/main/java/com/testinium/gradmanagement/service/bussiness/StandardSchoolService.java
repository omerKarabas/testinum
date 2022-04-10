package com.testinium.gradmanagement.service.bussiness;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testinium.gradmanagement.dto.request.SchoolRequest;
import com.testinium.gradmanagement.dto.response.SchoolResponse;
import com.testinium.gradmanagement.entity.School;
import com.testinium.gradmanagement.repository.SchoolRepository;
import com.testinium.gradmanagement.service.SchoolService;

@Service
public class StandardSchoolService implements SchoolService {

	private SchoolRepository  schoolRepository;
	private ModelMapper modelMapper;
	
	public StandardSchoolService(SchoolRepository schoolRepository, ModelMapper modelMapper) {
		super();
		this.schoolRepository = schoolRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public SchoolResponse addSchool(SchoolRequest schoolRequest) {
		
		var addedSchool = schoolRepository.save(modelMapper.map(schoolRequest, School.class));
		return modelMapper.map(addedSchool, SchoolResponse.class);
	}

	@Override
	@Transactional
	public SchoolResponse removeSchool(int schoolId) {
		
		var removedSchool = schoolRepository.findSchoolById(schoolId);
		schoolRepository.delete(removedSchool);
		
		return modelMapper.map(removedSchool, SchoolResponse.class);
	}

	@Override
	@Transactional
	public SchoolResponse updateSchoolNameById(int schoolId, SchoolRequest schoolRequest) {
		
		var updatedSchool =schoolRepository.findSchoolById(schoolId);
		updatedSchool.setSchoolName(schoolRequest.getSchoolName());
		
		return modelMapper.map(updatedSchool, SchoolResponse.class);
	}
	
	@Override
	public SchoolResponse findSchoolById(int schoolId) {
		
		return modelMapper.map(schoolRepository.findSchoolById(schoolId), SchoolResponse.class);
	}

}
