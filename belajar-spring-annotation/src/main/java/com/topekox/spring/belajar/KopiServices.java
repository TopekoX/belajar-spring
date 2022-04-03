package com.topekox.spring.belajar;

import org.springframework.stereotype.Component;

@Component
public class KopiServices implements MinumanServices {

	@Override
	public String getMinum() {
		return "Mau minum Kopi Hitam tanpa Gula";
	}

}
