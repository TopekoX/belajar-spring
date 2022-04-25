package com.topekox.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topekox.spring.rest.entity.Student;
import com.topekox.spring.rest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	private List<Student> students;

	// definisikan @PostCustruct, untuk memanggil method load data... satu kali
	// saja!!!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();

		students.add(new Student("Uzumaki", "Naruto"));
		students.add(new Student("Uciha", "Sasuke"));
		students.add(new Student("Hyuga", "Hinata"));
	}

	// Get Student List
	@GetMapping("/list")
	public List<Student> getListStudent() {
		return students;
	}

	// Get Student by Id (nama @PathVariable harus sama dengan param di
	// @GetMapping({...})
	@GetMapping("/list/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check student id
		if (studentId > students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return students.get(studentId);
	}	

}
