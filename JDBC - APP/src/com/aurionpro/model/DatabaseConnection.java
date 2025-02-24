package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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

			// ---------- execute query --------------
//			ResultSet resultSet = statement.executeQuery("Select * from students");
//
//			while (resultSet.next()) {
//				System.out.println(resultSet.getInt("studentId") + " " + resultSet.getInt("rollNumber") + " "
//						+ resultSet.getString("name") + " " + resultSet.getInt("age"));
//			}

			// --------- Long way insert --------------
//			int insert = statement.executeUpdate(
//					"INSERT INTO students(studentId, rollNumber, name, age) VALUES(1, 1001, 'student2', 20)");
//
//			System.out.printf("Success - " + insert + " - rows affected.\n");

			// ---------- Easy way to insert -----------
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into students values(?,?,?,?)");
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter student Id: ");
			int studentId = scanner.nextInt();
			
			System.out.print("Enter Roll Number: ");
			int rollNumber = scanner.nextInt();
			
			scanner.nextLine();
			System.out.print("Enter Name: ");
			String name = scanner.nextLine();
			
			System.out.print("Enter age: ");
			int age = scanner.nextInt();
			
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, rollNumber);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, age);
			
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = statement.executeQuery("Select * from students");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("studentId") + " " + resultSet.getInt("rollNumber") + " "
						+ resultSet.getString("name") + " " + resultSet.getInt("age"));
			}
			
			scanner.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
