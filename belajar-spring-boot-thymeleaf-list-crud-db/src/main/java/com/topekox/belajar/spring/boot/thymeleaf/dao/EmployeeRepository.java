package com.topekox.belajar.spring.boot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topekox.belajar.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// add method sort by last name by Spring JPA Magic
	// search more by keyword "spring data jpa query methods"
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
