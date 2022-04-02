package com.github.topekox;

import com.github.topekox.dao.ProdukDao;
import com.github.topekox.model.Produk;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class ManualDepedencyInjection {
     
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/belajar_spring";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static DataSource koneksi() {
        try {
            Class.forName(DB_DRIVER);
            MysqlDataSource ds = new MysqlDataSource();
            ds.setURL(DB_URL);
            ds.setUser(DB_USER);
            ds.setPassword(DB_PASSWORD);
            return ds;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        
        Produk p = new Produk();
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal(10000.23));
        
        System.out.println("Kode Produk : " + p.getKode());
        System.out.println("Nama Produk : " + p.getNama());
        System.out.println("Harga Produk : " + p.getHarga());
        
        ProdukDao pd = new ProdukDao();
        pd.setDS(koneksi());
        pd.simpan(p);
        
    }
    
}
