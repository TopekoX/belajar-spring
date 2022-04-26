package com.topekox.spring.rest.crud.dao;

import java.util.List;

import com.topekox.spring.rest.crud.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getListCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
}
