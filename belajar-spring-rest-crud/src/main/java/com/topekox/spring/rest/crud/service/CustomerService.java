package com.topekox.spring.rest.crud.service;

import java.util.List;

import com.topekox.spring.rest.crud.entity.Customer;

public interface CustomerService {

public List<Customer> getListCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
}
