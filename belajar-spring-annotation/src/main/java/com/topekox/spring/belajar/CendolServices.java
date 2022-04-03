package com.topekox.spring.belajar;

import org.springframework.stereotype.Component;

@Component
public class CendolServices implements MinumanServices {

	@Override
	public String getMinum() {
		return "Mau minum cendol gan...";
	}

}
