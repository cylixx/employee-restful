package com.softland.employeeresful.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softland.employeeresful.vo.Employee;

@Service
public class EmployeeMockService {
	private static List<Employee> employees;
	private static Long id = 0l;
	
	static {
		employees = Arrays.asList(
				new Employee(++id, "Marco Hinojosa", "Bank Payments"),
				new Employee(++id, "Selene Lopez", "SAP"),
				new Employee(++id, "Kumar Rabin", "Cards"),
				new Employee(++id, "Salma Hayek", "Publicity")
				);
	}
	
	public List<Employee> getAllEmployee() {
		return employees;
	}
	
	public Employee getEmployee(int id) {
		return employees.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}
}
