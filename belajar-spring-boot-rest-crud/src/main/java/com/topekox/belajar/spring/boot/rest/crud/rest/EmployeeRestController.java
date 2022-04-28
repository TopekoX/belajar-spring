package com.topekox.belajar.spring.boot.rest.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topekox.belajar.spring.boot.rest.crud.dao.EmployeeDAO;
import com.topekox.belajar.spring.boot.rest.crud.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
}
