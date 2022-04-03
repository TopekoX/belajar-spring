package com.topekox.spring.belajar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// load file configurasi
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AplikasiConfig.class);

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
