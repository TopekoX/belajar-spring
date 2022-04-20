package com.tutorialtimposu.spring.service;

import java.util.List;

import com.tutorialtimposu.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustumers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
