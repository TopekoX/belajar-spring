package com.topekox.spring.belajar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
	
		// load file configurasi
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// mengambil bean dari spring containner
		Makanan makanan = context.getBean("nasiGoreng", Makanan.class);
		
		// memanggil method dalam bean
		System.out.println(makanan.getMakan());
		
		// memanggil method minuman
		System.out.println(makanan.getMinuman());
		
		// close context
		context.close();
	}

}
