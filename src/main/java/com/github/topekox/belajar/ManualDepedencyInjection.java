package com.github.topekox.belajar;

import com.github.topekox.belajar.dao.ProdukDao;
import com.github.topekox.belajar.entity.Produk;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class ManualDepedencyInjection 
{
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/belajar_spring";
    private static final String DB_USER = "ucup";
    private static final String DB_PASSWORD = "123456";
    
    public static DataSource connectionToDB() {
        try {
            Class.forName(DB_DRIVER);
            MysqlDataSource c = new MysqlDataSource();
            c.setURL(DB_URL);
            c.setUser(DB_USER);
            c.setPassword(DB_PASSWORD);
         
            return c;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Produk p = new Produk();
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal("150500.00"));
        
        System.out.println("Kode Produk : " + p.getKode());
        System.out.println("Nama Produk : " + p.getNama());
        System.out.println("Harga Produk : " + p.getHarga());
        
        ProdukDao pd = new ProdukDao();
        pd.setDataSourceKeDatabase(connectionToDB());
        pd.simpan(p);
    }
}
