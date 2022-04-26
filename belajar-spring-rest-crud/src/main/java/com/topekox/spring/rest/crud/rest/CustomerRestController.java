package com.topekox.spring.rest.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topekox.spring.rest.crud.entity.Customer;
import com.topekox.spring.rest.crud.except.CustomerNotFoundException;
import com.topekox.spring.rest.crud.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> list() {
		return customerService.getListCustomers();
	}
	
	@GetMapping("/customer/{idCustumer}")
	public Customer getCustomer(@PathVariable int idCustumer) {
		
		Customer customer = customerService.getCustomer(idCustumer);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer ID Not Found - " + idCustumer);
		}
		
		return customer;
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {		
		
		customer.setId(0);
		customerService.saveCustomer(customer);
		
		return customer;
	}

}
