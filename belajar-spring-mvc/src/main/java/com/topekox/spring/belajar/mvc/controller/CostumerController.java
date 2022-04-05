package com.topekox.spring.belajar.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topekox.spring.belajar.mvc.model.Costumer;

@Controller
@RequestMapping("/costumer")
public class CostumerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("costumer", new Costumer());
		
		return "costumer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("costumer") Costumer costumer,
			BindingResult bindingResult) {
			
		if (bindingResult.hasErrors()) {
			return "costumer-form";
		} else {
			return "costumer-confirmation";
		}		
	}

}
