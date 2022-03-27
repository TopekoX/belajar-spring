package com.github.topekox.belajar.dao;

import com.github.topekox.belajar.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository("personDaoSpring")
public class PersonDaoSpring implements PersonDao {
    
    private SimpleJdbcInsert insertPerson;
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
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

    @Override
    public Person findPersonById(Integer id) {
        String sql = "select * from person where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PersonRowMapper());
    }
    
    private class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            Person p = new Person();
            p.setId(rs.getInt("id"));
            p.setNama(rs.getString("nama"));
            p.setAlamat(rs.getString("alamat"));
            
            return p;
        }
        
    }
    
}
