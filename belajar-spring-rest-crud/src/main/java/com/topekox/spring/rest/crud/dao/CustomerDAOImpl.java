package com.topekox.spring.rest.crud.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topekox.spring.rest.crud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getListCustomers() {
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery(
				"from Customer order by lastName", Customer.class);

		List<Customer> listCustomers = query.getResultList();

		return listCustomers;
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		session.remove(customer);
		
//		Cara 2 : with query
//		Query query = session.createQuery("delete from Customer where id=:id");
//		query.setParameter("id", id);
//		query.executeUpdate();
	}

}
