package com.aurionpro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/banking_db?useSSL=false";
	private static final String USER = "root"; // Update with your MySQL username
	private static final String PASSWORD = "root"; // Update with your MySQL password

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("MySQL Driver not found", e);
		}
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}