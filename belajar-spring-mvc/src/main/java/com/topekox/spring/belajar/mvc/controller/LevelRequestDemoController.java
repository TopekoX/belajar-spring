package com.topekox.spring.belajar.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LevelRequestDemoController {

	// membuat controller method proses
	@RequestMapping("/showForm")
	public String displayTheform() {
		return "helloWorld-form";
	}
	
}
