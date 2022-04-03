package com.topekox.spring.belajar;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

public class NasiKuning implements Makanan {

	private MinumanServices minumanServices;

	@Value("${foo.porsi}")
	private String porsi;

	@Value("${foo.value}")
	private String value;

	public NasiKuning(MinumanServices minumanServices) {
		System.out.println(">> NasiKuning : menjalankan constructor");
		this.minumanServices = minumanServices;
	}

	public String getPorsi() {
		return porsi;
	}

	public String getValue() {
		return value;
	}

	// mendefinisikan init method
	@PostConstruct
	public void initMethod() {
		System.out.println(">> NasiKuning : menjalankan method initMethod()");
	}

	// mendefinisikan destroy method
	@PreDestroy
	public void destroyMethod() {
		System.out.println(">> NasiKuning : menjalankan method destroyMethod()");
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
