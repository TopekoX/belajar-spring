package com.topekox.spring.belajar.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	
	// membuat method show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}
	
	// membuat controller method proses
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
}
