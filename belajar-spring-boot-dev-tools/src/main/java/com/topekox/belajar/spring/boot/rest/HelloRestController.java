package com.topekox.belajar.spring.boot.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World!!! Time server is = " + LocalDateTime.now();
	}
	
	@GetMapping("/message")
	public String sayMessage() {
		return "You are so handsome :-D";
	}
	
}
