package com.topekox.spring.belajar;

import org.springframework.stereotype.Component;

@Component
public class JusJerusService implements MinumanServices {

	@Override
	public String getMinum() {
		return "Mau minum Jus Jeruk....";
	}

}
