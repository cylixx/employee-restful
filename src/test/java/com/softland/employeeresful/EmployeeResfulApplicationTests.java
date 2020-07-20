package com.softland.employeeresful;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.softland.employeeresful.vo.Employee;

@SpringBootTest
class EmployeeResfulApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void getEmployee() {
		RestTemplate rt =  new RestTemplate();
		String url = "http://localhost:8080/employee/1";
		ResponseEntity<Employee> response = rt.getForEntity(url, Employee.class);
		//assertThat(response.getStatusCode(), equal(HttpStatus.OK));
		System.out.println("============ " + response.getBody());
		assertEquals(response.getStatusCode(), HttpStatus.OK); 
	}
}
