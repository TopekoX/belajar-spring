package com.github.topekox.belajar;

import com.github.topekox.belajar.dao.ProdukDao;
import com.github.topekox.belajar.entity.Produk;
import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDepedencyInjectionAnnotation {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(KonfigurasiAplikasi.class);
        
        Produk p = new Produk(); 
        p.setKode("P-005");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal("150500.00"));
        
        System.out.println("Kode Produk : " + p.getKode());
        System.out.println("Nama Produk : " + p.getNama());
        System.out.println("Harga Produk : " + p.getHarga());
        
        ProdukDao pd = (ProdukDao) applicationContext.getBean("pd");
        pd.simpan(p);
    }
        
}
