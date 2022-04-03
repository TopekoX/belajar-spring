package com.topekox.spring.belajar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CapTikusJavaConfigDemoApp {

	public static void main(String[] args) {

		// load file configurasi
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AplikasiConfig.class);

		// mengambil bean dari spring containner
		Makanan makanan = context.getBean("nasiKuning", Makanan.class);

		// memanggil method dalam bean
		System.out.println(makanan.getMakan());

		// memanggil method minuman
		System.out.println(makanan.getMinuman());

		// close context
		context.close();

	}

}
