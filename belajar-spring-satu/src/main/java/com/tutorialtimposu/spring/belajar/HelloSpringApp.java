package com.tutorialtimposu.spring.belajar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load file spring konfigurasi
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// memanggil bean dari spring container
		Mahasiswa mahasiswa = context.getBean("mahasiswa", Mahasiswa.class);
				
		//  memamnggil method dari bean
		System.out.println(mahasiswa.getFakultas());
		
		// memanggil method dari jadwal
		System.out.println(mahasiswa.getJadwalHarian());
		
		// close application context
		context.close();
	}

}
