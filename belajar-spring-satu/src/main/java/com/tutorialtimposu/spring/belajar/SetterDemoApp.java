package com.tutorialtimposu.spring.belajar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// mengambil bean dari spring containner
		CitraMahasiswa mahasiswa = context.getBean("citraMahasiswa", CitraMahasiswa.class);
				
		// memanggil method di dalam bean
		System.out.println(mahasiswa.getFakultas());
		
		System.out.println(mahasiswa.getJadwalHarian());
		
		// memanggil method literal
		System.out.println(mahasiswa.getEmail());
		
		System.out.println(mahasiswa.getAlamat());
		
		// close context
		context.close();
	}

}
