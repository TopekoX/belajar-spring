package com.topekox.spring.rest.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topekox.spring.rest.crud.entity.Customer;
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
		return customerService.getCustomer(idCustumer);
	}

}
