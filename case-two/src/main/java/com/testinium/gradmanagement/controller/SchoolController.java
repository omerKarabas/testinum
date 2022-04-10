package com.testinium.gradmanagement.controller;

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

import com.testinium.gradmanagement.dto.request.SchoolRequest;
import com.testinium.gradmanagement.dto.response.SchoolResponse;
import com.testinium.gradmanagement.service.SchoolService;

@RestController
@RequestScope
@RequestMapping("/schools")
@CrossOrigin
@Validated
public class SchoolController {

	private SchoolService  schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping
	public SchoolResponse addSchool (@RequestBody SchoolRequest schoolRequest){
		return schoolService.addSchool(schoolRequest);
	}
	
	@DeleteMapping("{schoolid}")
	public SchoolResponse removeSchool(@PathVariable int schoolId) {
		return schoolService.removeSchool(schoolId);
	}
	
	@PutMapping("{schoolid}")
	public SchoolResponse updateSchoolNameById(@PathVariable int schoolId,@RequestBody SchoolRequest schoolRequest) {
		return schoolService.updateSchoolNameById(schoolId, schoolRequest);
	}
	
	@GetMapping("{schoolid}")
	public SchoolResponse findSchoolById(@PathVariable int schoolId) {
		return schoolService.findSchoolById(schoolId);
	}
}
