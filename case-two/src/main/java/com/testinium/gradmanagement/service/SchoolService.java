package com.testinium.gradmanagement.service;

import com.testinium.gradmanagement.dto.request.SchoolRequest;
import com.testinium.gradmanagement.dto.response.SchoolResponse;

public interface SchoolService {
	
	//Writeable 
	SchoolResponse addSchool(SchoolRequest schoolRequest);
	SchoolResponse removeSchool(int schoolId);
	SchoolResponse updateSchoolNameById(int schoolId,SchoolRequest schoolRequest);
	
	//Readable 
	SchoolResponse findSchoolById(int schoolId);
	
	
	
	
}
