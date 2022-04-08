package com.topekox.spring.belajar.mvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.topekox.spring.belajar.mvc.validation.CourseCode;

public class Costumer {

	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@NotNull(message = "is required")
	@Min(value=0, message="nilai harus >= 0")
	@Max(value=10, message = "nilai harus <= 10")
	private Integer tiketGratis;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}", message = "hanya 5 char/digit")
	private String nomorResi;	
	
	@CourseCode(value = "TES", message = "must start with TES")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getNomorResi() {
		return nomorResi;
	}

	public void setNomorResi(String nomorResi) {
		this.nomorResi = nomorResi;
	}

	public Integer getTiketGratis() {
		return tiketGratis;
	}

	public void setTiketGratis(Integer tiketGratis) {
		this.tiketGratis = tiketGratis;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
