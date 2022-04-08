package com.topekox.spring.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost/belajar_spring";
		String user = "ucup";
		String pass = "topeko";
		
		System.out.println("Connection: " + url);
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Successfull");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
