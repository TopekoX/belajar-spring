package com.github.topekox.belajar;

import com.github.topekox.belajar.dao.ProdukDao;
import com.github.topekox.belajar.entity.Produk;import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDI {
    
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext 
                = new ClassPathXmlApplicationContext("belajar-ioc.xml");
               
        // cara manual
//      Produk p = new Produk(); 
        
        // cara spring
        Produk p = (Produk) applicationContext.getBean("p"); 
        
        System.out.println("Kode Produk : " + p.getKode());
        System.out.println("Nama Produk : " + p.getNama());
        System.out.println("Harga Produk : " + p.getHarga());
        
        ProdukDao pd = (ProdukDao) applicationContext.getBean("pd");
        pd.simpan(p);
    }
}
