package com.topekox.spring.belajar.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// controller method untuk membaca data dan 
	// menambahkan data ke model
	@RequestMapping("/processForm2")
	public String letsShoutDude(HttpServletRequest request, 
			Model model) {
		
		// read request parameter from html form
		String theName = request.getParameter("studentName");
		
		// convert data
		theName = theName.toUpperCase();
		
		// create message
		String result = "Yoo! " + theName;
		
	    // add message to model	
		model.addAttribute("message", result);
		
		return "helloWorld";
	}
	
	// controller request parameter
	@RequestMapping("/processForm3")
	public String processForm3(@RequestParam("studentName") String theName, 
			Model model) {
		
		// convert data
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hey My friends from V3! " + theName;
		
	    // add message to model	
		model.addAttribute("message", result);
		
		return "helloWorld";
	}
	
}
