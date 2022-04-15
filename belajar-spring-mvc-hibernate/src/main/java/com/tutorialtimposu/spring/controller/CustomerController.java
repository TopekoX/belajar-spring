package com.tutorialtimposu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorialtimposu.spring.entity.Customer;
import com.tutorialtimposu.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customers = customerService.getCustumers();
		
		model.addAttribute("customer", customers);
		
		return "list-customers";
	}

}
