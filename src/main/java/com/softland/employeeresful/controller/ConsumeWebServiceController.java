package com.softland.employeeresful.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.softland.employeeresful.vo.Employee;

@RestController
public class ConsumeWebServiceController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/template/employee/{id}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		if(employee.getId() == null) employee.setId(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		return restTemplate.exchange("http://localhost:8080/employee/", HttpMethod.POST, entity, String.class)
				.getBody();

	}
	
}
