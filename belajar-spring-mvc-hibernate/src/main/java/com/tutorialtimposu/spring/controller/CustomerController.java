package com.tutorialtimposu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorialtimposu.spring.dao.CustomerDAO;
import com.tutorialtimposu.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customers = customerDAO.getCustomers();
		
		model.addAttribute("customer", customers);
		
		return "list-customers";
	}

}
