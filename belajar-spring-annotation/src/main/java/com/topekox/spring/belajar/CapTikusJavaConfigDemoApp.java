package com.topekox.spring.belajar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CapTikusJavaConfigDemoApp {

	public static void main(String[] args) {

		// load file configurasi
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AplikasiConfig.class);

		// mengambil bean dari spring containner
		NasiKuning makanan = context.getBean("nasiKuning", NasiKuning.class);

		// memanggil method dalam bean
		System.out.println(makanan.getMakan() + " " + makanan.getPorsi());

		// memanggil method minuman
		System.out.println(makanan.getMinuman() + " " + makanan.getValue());

		// close context
		context.close();

	}

}
