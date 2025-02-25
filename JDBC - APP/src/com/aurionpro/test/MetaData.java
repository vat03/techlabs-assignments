package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MetaData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");

			Statement statement = connection.createStatement();

			DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();

			System.out.println("Database type: " + metaData.getDatabaseProductName());

			System.out.println();

			System.out.println("Tables in the database:");
			ResultSet resultSet = metaData.getTables("college", null, "%", new String[] { "TABLE" });
			while (resultSet.next()) {
				String tableName = resultSet.getString("TABLE_NAME");
				System.out.println("\nTable name: " + tableName);
				ResultSet rs = statement.executeQuery("select * from " + tableName);
				ResultSetMetaData resultSetMetaData = (ResultSetMetaData) rs.getMetaData();
				System.out.println("List of column names in the table " + tableName + ": ");
				int count = resultSetMetaData.getColumnCount();
				for (int i = 1; i <= count; i++) {
					System.out.println(
							resultSetMetaData.getColumnName(i) + " -> " + resultSetMetaData.getColumnTypeName(i));
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
