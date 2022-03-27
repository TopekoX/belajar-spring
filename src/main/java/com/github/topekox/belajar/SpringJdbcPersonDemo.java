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
        
        System.out.println("ID: " + p.getId());
    }
}
