package com.github.topekox.belajar.dao;

import com.github.topekox.belajar.entity.Person;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository("personDaoSpring")
public class PersonDaoSpring implements PersonDao {
    
    private SimpleJdbcInsert insertPerson;
    
    @Autowired
    public void setDataSource(DataSource ds) {
        insertPerson = new SimpleJdbcInsert(ds)
                .withTableName("person")
                .usingColumns("nama", "alamat")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Person p) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("nama", p.getNama());
        param.put("alamat", p.getAlamat());
        
        Number id = insertPerson.executeAndReturnKey(param);
        p.setId(id.intValue());
    }
    
}
