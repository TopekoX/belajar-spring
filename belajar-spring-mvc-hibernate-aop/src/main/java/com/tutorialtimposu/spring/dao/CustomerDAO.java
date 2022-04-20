package com.tutorialtimposu.spring.dao;

import java.util.List;

import com.tutorialtimposu.spring.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);

}
