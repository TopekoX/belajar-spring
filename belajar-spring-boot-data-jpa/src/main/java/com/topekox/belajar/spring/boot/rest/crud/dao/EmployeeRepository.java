package com.topekox.belajar.spring.boot.rest.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topekox.belajar.spring.boot.rest.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
