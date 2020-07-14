package com.softland.employeeresful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.softland.employeeresful.service.EmployeeService;
import com.softland.employeeresful.vo.Employee;

@CrossOrigin(origins = "http://localhost:4200")  // important to invoke this service from other domain
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// Annotation for mapping HTTP GET requests onto specific handler methods.
	// Specifically, @GetMapping is a composed annotation that acts as a shortcut for 
	// @RequestMapping(method = RequestMethod.GET).
	@GetMapping("/employee") 
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		Employee e = employeeService.getEmployee(id);
		if (e == null) return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

}
