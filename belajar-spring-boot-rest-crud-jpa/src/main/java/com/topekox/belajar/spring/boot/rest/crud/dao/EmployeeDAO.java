package com.topekox.belajar.spring.boot.rest.crud.dao;

import java.util.List;

import com.topekox.belajar.spring.boot.rest.crud.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);
	
}
