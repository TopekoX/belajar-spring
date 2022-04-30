package com.topekox.belajar.spring.boot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.topekox.belajar.spring.boot.thymeleaf.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private List<Employee> listEmployees;

	@PostConstruct
	private void loadData() {

		Employee emp1 = new Employee("Uzumaki", "Naruto", "naruto@naruto.com");
		Employee emp2 = new Employee("Ronoroa", "Zoro", "zoro@onepiece.com");
		Employee emp3 = new Employee("Eren", "Yeager", "eren@aot.com");
		
		listEmployees = new ArrayList<>();

		listEmployees.add(emp1);
		listEmployees.add(emp2);
		listEmployees.add(emp3);		
	}
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		model.addAttribute("employees", listEmployees);
		
		return "list-employees";
	}

}
