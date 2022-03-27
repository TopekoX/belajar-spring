package com.github.topekox.belajar.dao;

import com.github.topekox.belajar.entity.Person;

public interface PersonDao {
    public void save(Person p);
    
    public Person findPersonById(Integer id);
}
