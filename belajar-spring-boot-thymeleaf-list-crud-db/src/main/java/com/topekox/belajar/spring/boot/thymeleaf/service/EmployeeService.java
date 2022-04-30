package com.topekox.belajar.spring.boot.thymeleaf.service;

import java.util.List;

import com.topekox.belajar.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();

	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);

}
