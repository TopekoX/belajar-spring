package com.topekox.belajar.spring.boot.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topekox.belajar.spring.boot.thymeleaf.entity.Employee;
import com.topekox.belajar.spring.boot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployee(Model model) {
		List<Employee> listEmployees = employeeService.findAll();
		model.addAttribute("employees", listEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		Employee theEmployee = new Employee();
		model.addAttribute("employee", theEmployee);

		return "employees/form-employees";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.save(employee);
		
		// redirect
		return "redirect:/employee/list";
	}

}
