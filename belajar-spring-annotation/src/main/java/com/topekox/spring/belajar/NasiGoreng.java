package com.topekox.spring.belajar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("makanNasiGoreng")
@Component
public class NasiGoreng implements Makanan {

	// mendefinisikan field injection
	@Autowired
	private MinumanServices minumanServices;
	
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
	/*@Autowired
	public void setMinumanServices(MinumanServices minumanServices) {
		System.out.println(">> NasiGoreng: di dalam setMinumanService method");
		this.minumanServices = minumanServices;
	}*/
	
	// mendefenisikan method injection
	/*@Autowired
	public void pesanMinuman(MinumanServices minumanServices) {
		System.out.println(">> NasiGoreng: di dalam method pesanMinuman()");
		this.minumanServices = minumanServices;
	}*/

	@Override
	public String getMakan() {
		return "Sarapan hari ini Nasi Goreng";
	}

	@Override
	public String getMinuman() {
		return minumanServices.getMinum();
	}

}
