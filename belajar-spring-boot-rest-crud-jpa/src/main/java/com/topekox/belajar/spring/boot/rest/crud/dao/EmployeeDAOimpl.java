package com.topekox.belajar.spring.boot.rest.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	public List<Employee> findAll() {
		
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery(
				"from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList(); 
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();		
	}
	
}
