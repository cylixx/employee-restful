package com.softland.employeeresful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softland.employeeresful.vo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
