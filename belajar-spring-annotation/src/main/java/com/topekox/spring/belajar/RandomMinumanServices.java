package com.topekox.spring.belajar;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomMinumanServices implements MinumanServices {

	private String[] data = {
			"Pesan minuman Jamu Kuat",
			"Pesan Kopi Susu",
			"Pesan Jus Tomat",
			"Pesan Jus Jengkol"
	};
	
	private Random acak = new Random();
	
	@Override
	public String getMinum() {
		int index = acak.nextInt(data.length);
		
		String minumanku = data[index];
		
		return minumanku;
	}

}
