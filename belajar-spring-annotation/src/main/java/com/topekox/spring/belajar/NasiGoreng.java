package com.topekox.spring.belajar;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("makanNasiGoreng")
@Component
//@Scope("prototype")
public class NasiGoreng implements Makanan {

	// mendefinisikan field injection
//	@Autowired
//	@Qualifier("randomMinumanServices")
	private MinumanServices minumanServices;
	
	@Value("${foo.porsi}")
	private String porsi;
	
	@Value("${foo.value}")
	private String value;
	
	// mendefinisikan default constructor
	public NasiGoreng() {
		System.out.println(">> NasiGoreng: di dalam default constructor");
	}
	
	// mendifinisikan constructor injection
	/*
	@Autowired
	public NasiGoreng(MinumanServices minumanServices) {
		this.minumanServices = minumanServices;
	}*/
	
	// mendefinisikan setter injection
	@Autowired
	public void setMinumanServices(@Qualifier("kopiServices") MinumanServices minumanServices) {
		System.out.println(">> NasiGoreng: di dalam setMinumanService method");
		this.minumanServices = minumanServices;
	}
	
	// mendefenisikan method injection
	/*@Autowired
	public void pesanMinuman(MinumanServices minumanServices) {
		System.out.println(">> NasiGoreng: di dalam method pesanMinuman()");
		this.minumanServices = minumanServices;
	}*/
	
	// mendefinisikan init method
	@PostConstruct
	public void initMethod() {
		System.out.println(">> NasiGoreng : menjalankan method initMethod()");
	}
	
	// mendefinisikan destroy method
	@PreDestroy
	public void destroyMethod() {
		System.out.println(">> NasiGoreng : menjalankan method destroyMethod()");
	}

	@Override
	public String getMakan() {
		return "Sarapan hari ini Nasi Goreng " + porsi;
	}

	@Override
	public String getMinuman() {
		return minumanServices.getMinum() + " " + value;
	}

}
