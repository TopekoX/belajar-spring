package com.github.topekox;

import com.github.topekox.dao.ProdukDao;
import com.github.topekox.model.Produk;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDepedencyInjection {
    
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext 
                = new ClassPathXmlApplicationContext("belajar-ioc.xml");
        
        Produk p = (Produk) applicationContext.getBean("p");
        
        System.out.println(p.getKode());
        System.out.println(p.getNama());
        System.out.println(p.getHarga());
        
        ProdukDao pd = (ProdukDao) applicationContext.getBean("pd");
        pd.simpan(p);
        applicationContext.close();
    }
    
}
