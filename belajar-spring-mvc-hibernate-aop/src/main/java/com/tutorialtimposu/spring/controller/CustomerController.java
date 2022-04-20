package com.tutorialtimposu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,
			Model model) {
		
		// get customer by id from db
		Customer customer = customerService.getCustomer(id);
		
		// set customer as model
		model.addAttribute("customer", customer);
		
		// send to form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id,
			Model model) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}

}
