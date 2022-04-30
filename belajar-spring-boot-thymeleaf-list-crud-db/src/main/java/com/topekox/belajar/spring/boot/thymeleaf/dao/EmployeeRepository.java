package com.topekox.belajar.spring.boot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topekox.belajar.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
