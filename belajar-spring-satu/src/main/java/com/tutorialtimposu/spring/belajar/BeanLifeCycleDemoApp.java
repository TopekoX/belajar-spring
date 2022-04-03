package com.tutorialtimposu.spring.belajar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load spring file konfigurasi
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		// mengambil bean dari spring container
		Mahasiswa mahasiswa = context.getBean("mahasiswa", Mahasiswa.class);
		
		// print hasil
		System.out.println(mahasiswa.getFakultas());
			
		// close context
		context.close();
	}

}
