package com.topekox.spring.belajar;

import org.springframework.beans.factory.annotation.Value;

public class NasiKuning implements Makanan {
	
	private MinumanServices minumanServices;
	
	@Value("${foo.porsi}")
	private String porsi;
	
	@Value("${foo.value}")
	private String value;
	
	public String getPorsi() {
		return porsi;
	}

	public String getValue() {
		return value;
	}

	public NasiKuning(MinumanServices minumanServices) {
		this.minumanServices = minumanServices;
	}

	@Override
	public String getMakan() {
		return "Makan Nasi Kuning Mama Jeni.";
	}

	@Override
	public String getMinuman() {
		return minumanServices.getMinum();
	}

}
