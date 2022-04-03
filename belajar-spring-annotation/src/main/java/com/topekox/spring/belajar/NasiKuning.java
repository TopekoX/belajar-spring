package com.topekox.spring.belajar;

public class NasiKuning implements Makanan {
	
	private MinumanServices minumanServices;
	
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
