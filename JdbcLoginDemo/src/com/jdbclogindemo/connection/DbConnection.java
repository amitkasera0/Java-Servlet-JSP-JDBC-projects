package com.jdbclogindemo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getDatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/logreg?useSSL=false",
			"root", "root");
			return con;
		} catch (SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
			return null;
		}
	}
}
