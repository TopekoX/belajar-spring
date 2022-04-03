package com.topekox.spring.belajar;

import org.springframework.stereotype.Component;

@Component("makanNasiGoreng")
public class NasiGoreng implements Makanan {

	public String getMakan() {
		return "Sarapan hari ini Nasi Goreng";
	}

}
