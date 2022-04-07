package com.topekox.spring.belajar.mvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Costumer {

	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@Min(value=0, message="nilai harus >= 0")
	@Max(value=10, message = "nilai harus <= 10")
	private int tiketGratis;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}", message = "hanya 5 char/digit")
	private String nomorResi;	
	
	public String getNomorResi() {
		return nomorResi;
	}

	public void setNomorResi(String nomorResi) {
		this.nomorResi = nomorResi;
	}

	public int getTiketGratis() {
		return tiketGratis;
	}

	public void setTiketGratis(int tiketGratis) {
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
