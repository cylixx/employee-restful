package com.softland.employeeresful.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softland.employeeresful.repository.EmployeeRepository;
import com.softland.employeeresful.vo.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployee(Long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.orElse(null);
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
