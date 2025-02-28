package com.aurionpro.model;

import java.sql.*;

public class Students {
	private Connection connection;

	public Students() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void addStudent(int studentId, int rollNumber, String name, int age) {
		String checkQuery = "SELECT COUNT(*) FROM students WHERE studentId = ?";
		try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
			checkStmt.setInt(1, studentId);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				System.out.println("Student ID " + studentId + " already exists!");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Error checking student ID: " + e.getMessage());
			return;
		}

		String query = "INSERT INTO students (studentId, rollnumber, name, age) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, studentId);
			stmt.setInt(2, rollNumber);
			stmt.setString(3, name);
			stmt.setInt(4, age);
			stmt.executeUpdate();
			System.out.println("Student added successfully!");
		} catch (SQLException e) {
			System.out.println("Failed to add student: " + e.getMessage());
		}
	}

	public void getAllStudents() {
		try (Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
			while (rs.next()) {
				System.out.printf("StudentID: %d, Roll: %d, Name: %s, Age: %d%n", rs.getInt("studentId"),
						rs.getInt("rollnumber"), rs.getString("name"), rs.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving students: " + e.getMessage());
		}
	}

	public void updateStudent(int studentId, String name, int age) {
		String query = "UPDATE students SET name = ?, age = ? WHERE studentId = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setInt(3, studentId);
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Student updated successfully!");
			} else {
				System.out.println("No student found with ID: " + studentId);
			}
		} catch (SQLException e) {
			System.out.println("Error updating student: " + e.getMessage());
		}
	}

	public void deleteStudent(int studentId) {
		String query = "DELETE FROM students WHERE studentId = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, studentId);
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Student deleted successfully!");
			} else {
				System.out.println("No student found with ID: " + studentId);
			}
		} catch (SQLException e) {
			System.out.println("Error deleting student: " + e.getMessage());
		}
	}
}