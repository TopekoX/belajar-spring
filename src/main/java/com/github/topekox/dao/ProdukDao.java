package com.github.topekox.dao;

import com.github.topekox.model.Produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class ProdukDao {
    
    private final String SQL_SIMPAN = "insert into produk (kode, nama, harga) values (?,?,?)";
    
    private DataSource ds;

//    public ProdukDao(DataSource ds) {
//        this.ds = ds;
//    }

    public void setDS(DataSource ds) {
        this.ds = ds;
    }
        
    public void simpan(Produk p) {
        Connection con = null;

        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            
            PreparedStatement ps = con.prepareStatement(SQL_SIMPAN);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setBigDecimal(3, p.getHarga());
            ps.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        finally {
//            try {
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } 
//        finally {
//            try {
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
    
    public List<Produk> cari() {
        List<Produk> hasil = new ArrayList<Produk>();
        
        return hasil;
    }
}
