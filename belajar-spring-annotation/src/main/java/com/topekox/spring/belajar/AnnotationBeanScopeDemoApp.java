package com.topekox.spring.belajar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// mengambil bean dari spring container
		Makanan makanan1 = context.getBean("nasiGoreng", Makanan.class);
		
		Makanan makanan2 = context.getBean("nasiGoreng", Makanan.class);
		
		// cek apakah merujuk ke objek yang sama
		boolean cek = (makanan1 == makanan2);
		
		System.out.println("\nMerujuk ke Objek yang sama: " + cek);
		
		System.out.println("\nLokasi Memory makanan1: " + makanan1);
		
		System.out.println("\nLokasi Memory makanan2: " + makanan2);
		
		// close context
		context.close();
	}

}
