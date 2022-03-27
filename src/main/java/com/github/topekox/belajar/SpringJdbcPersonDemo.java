package com.github.topekox.belajar;

import com.github.topekox.belajar.dao.PersonDao;
import com.github.topekox.belajar.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbcPersonDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(KonfigurasiAplikasi.class);
        
        Person p = new Person();
        p.setNama("Ucup");
        p.setAlamat("Palu");
        
//        PersonDao pd = (PersonDao) applicationContext.getBean("personDao");
        PersonDao pd = (PersonDao) applicationContext.getBean("personDaoSpring");
        pd.save(p);
        
        System.out.println("Berhasil Insert Data dengan ID: " + p.getId());
        
        Person px = pd.findPersonById(1);
        System.out.println("ID: " + px.getId());
        System.out.println("Nama: " + px.getNama());
        System.out.println("Alamat: " + px.getAlamat());
    }
}
