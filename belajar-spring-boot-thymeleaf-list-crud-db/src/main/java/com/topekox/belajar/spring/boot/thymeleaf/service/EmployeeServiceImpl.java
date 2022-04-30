package com.topekox.belajar.spring.boot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topekox.belajar.spring.boot.thymeleaf.dao.EmployeeRepository;
import com.topekox.belajar.spring.boot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
			return employee;
		} else {
			throw new RuntimeException("Employee Not Found with id - " + id);
		}
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
