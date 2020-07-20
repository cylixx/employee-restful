package com.softland.employeeresful.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String department;
	
	public Employee() {
		super();
	}

	public Employee(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}
	public Employee(int id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, department=%s]", id, name, department);
	}
	
}
