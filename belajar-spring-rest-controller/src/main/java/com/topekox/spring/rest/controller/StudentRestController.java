package com.topekox.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topekox.spring.rest.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@GetMapping("/list")
	public List<Student> getStudent() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Uzumaki", "Naruto"));
		students.add(new Student("Uciha", "Sasuke"));
		students.add(new Student("Hyuga", "Hinata"));
		
		return students;
	}
	
}
