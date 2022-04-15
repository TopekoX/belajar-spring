package com.tutorialtimposu.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialtimposu.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// get Current Session hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// create query
		Query<Customer> query =
				session.createQuery("from Customer", Customer.class);
		
		// execute query and get result
		List<Customer> customers = query.getResultList();
		
		// return result 
		return customers;
	}

}
