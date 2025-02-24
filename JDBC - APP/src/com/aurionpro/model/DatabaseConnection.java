package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public void connect() {
		try {
			// Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
					"root");

			System.out.println("Connection established successfully !!\n");

			// Create a statement
			Statement statement = connection.createStatement();

			// execute query
//			ResultSet resultSet = statement.executeQuery("Select * from students");
//
//			while (resultSet.next()) {
//				System.out.println(resultSet.getInt("studentId") + " " + resultSet.getInt("rollNumber") + " "
//						+ resultSet.getString("name") + " " + resultSet.getInt("age"));
//			}

			int insertSet = statement.executeUpdate(
					"INSERT INTO students(studentId, rollNumber, name, age) VALUES(3, 1003, 'student3', 20)");

			System.out.printf("Success - " + insertSet + " - rows affected.\n");

			ResultSet resultSet = statement.executeQuery("Select * from students");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("studentId") + " " + resultSet.getInt("rollNumber") + " "
						+ resultSet.getString("name") + " " + resultSet.getInt("age"));
			}

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
