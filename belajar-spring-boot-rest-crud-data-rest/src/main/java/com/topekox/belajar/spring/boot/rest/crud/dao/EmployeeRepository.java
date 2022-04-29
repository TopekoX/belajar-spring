package com.topekox.belajar.spring.boot.rest.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.topekox.belajar.spring.boot.rest.crud.entity.Employee;

//@RepositoryRestResource(path = "pegawai")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
