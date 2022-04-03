package com.tutorialtimposu.spring.belajar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring file konfigurasi
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// mengambil bean dari spring container
		Mahasiswa mahasiswa1 = context.getBean("mahasiswa", Mahasiswa.class);
		
		Mahasiswa mahasiswa2 = context.getBean("mahasiswa", Mahasiswa.class);
		
		// cek objek yang sama
		boolean result = (mahasiswa1 == mahasiswa2);
		
		// print hasil
		System.out.println("\nMengarah ke objek yang sama: " + result);
		System.out.println("\nLokasi di dalam memory: " + mahasiswa1);
		System.out.println("\nLokasi di dalam memory: " + mahasiswa2);
			
		// close context
		context.close();
	}

}
