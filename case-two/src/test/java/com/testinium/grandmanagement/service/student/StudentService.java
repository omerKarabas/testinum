package com.testinium.grandmanagement.service.student;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.gradmanagement.app.CaseTwoApplication;

@SpringBootTest(
		classes = CaseTwoApplication.class,
		webEnvironment = WebEnvironment.MOCK
	)
@AutoConfigureMockMvc
public class StudentService {

	
	
}
