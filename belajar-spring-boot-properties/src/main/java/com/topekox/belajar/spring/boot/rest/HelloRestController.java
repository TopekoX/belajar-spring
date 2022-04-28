package com.topekox.belajar.spring.boot.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	// inject properties
	@Value("${first.name}")
	private String firstName;
	
	@Value("${last.name}")
	private String lastName;

	@GetMapping("/")
	public String sayHello() {
		return "Hello World!!! Time server is = " + LocalDateTime.now();
	}
	
	@GetMapping("/message")
	public String sayMessage() {
		return "You are so handsome :-D";
	}
	
	@GetMapping("/person")
	public String getPerson() {
		return "Person Name : " + firstName + " " + lastName;
	}
	
}
