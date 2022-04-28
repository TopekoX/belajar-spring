package com.topekox.belajar.spring.boot.rest.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topekox.belajar.spring.boot.rest.crud.entity.Employee;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
	
	// define Entity Manager
	private EntityManager entityManager;
	
	// setup constructor auto injection from spring boot
	@Autowired
	public EmployeeDAOimpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery(
				"from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList(); 
		
		return employees;
	}
	
}
