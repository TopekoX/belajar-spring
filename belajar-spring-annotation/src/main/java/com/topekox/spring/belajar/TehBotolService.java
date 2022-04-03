package com.topekox.spring.belajar;

import org.springframework.stereotype.Component;

@Component
public class TehBotolService implements MinumanServices {

	@Override
	public String getMinum() {
		return "Apapun makanannya minumnya tetap teh botol SoSroooo";
	}

}
