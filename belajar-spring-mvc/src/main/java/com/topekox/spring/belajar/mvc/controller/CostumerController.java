package com.topekox.spring.belajar.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topekox.spring.belajar.mvc.model.Costumer;

@Controller
@RequestMapping("/costumer")
public class CostumerController {
	
	// @InitBinder akan dijalankan terlebih dahulu sebelum method lain.
	// Method ini akan menghapus spasi
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		// setiap objek bertipe String akan di trim
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("costumer", new Costumer());
		
		return "costumer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("costumer") Costumer costumer,
			BindingResult bindingResult) {
			
		System.out.println("Last Name: >>" + costumer.getLastName() + "<<");
		
		if (bindingResult.hasErrors()) {
			return "costumer-form";
		} else {
			return "costumer-confirmation";
		}		
	}

}
