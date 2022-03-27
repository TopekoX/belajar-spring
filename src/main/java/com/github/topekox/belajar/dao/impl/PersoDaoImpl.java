package com.github.topekox.belajar.dao.impl;

import com.github.topekox.belajar.dao.PersonDao;
import com.github.topekox.belajar.entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "personDao")
public class PersoDaoImpl implements PersonDao {
    
    @Autowired
    private DataSource dataSource;
    
    @Override
    public void save(Person p) {
        try {
            Connection con = dataSource.getConnection();
            con.setAutoCommit(false);
            
            String sql = "insert into person (nama, alamat) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getAlamat());
            ps.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Person findPersonById(Integer id) {
        try {
            Connection con = dataSource.getConnection();
            
            String sql = "select * from person where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            
            Person p = new Person();
            p.setId(rs.getInt("id"));
            p.setNama(rs.getString("nama"));
            p.setAlamat(rs.getString("alamat"));
            
            con.close();
            return p;            
        } catch (SQLException ex) {
            Logger.getLogger(PersoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
