package com.topekox.spring.belajar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("makanNasiGoreng")
@Component
public class NasiGoreng implements Makanan {

	private MinumanServices minumanServices;
	
	@Autowired
	public NasiGoreng(MinumanServices minumanServices) {
		this.minumanServices = minumanServices;
	}

	@Override
	public String getMakan() {
		return "Sarapan hari ini Nasi Goreng";
	}

	@Override
	public String getMinuman() {
		return minumanServices.getMinum();
	}

}
