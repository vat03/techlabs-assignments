package com.aurionpro.model;

import java.sql.*;

public class Subjects {
	private Connection connection;

	public Subjects() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	// Create Subjects
	public void addSubject(int subId, String subjectName) {
		String query = "INSERT INTO subjects (subId, subjectName) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subId);
			stmt.setString(2, subjectName);
			stmt.executeUpdate();
			System.out.println("Subject added successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Read Subjects
	public void getAllSubjects() {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from teachers");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("teacherId") + " " + resultSet.getInt("name") + " "
						+ resultSet.getString("qualification"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Update Subjects
	public void updateSubject(int id, String name) {
		String query = "UPDATE subjects SET subjectName = ? WHERE subId = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Subject updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete Subjects
	public void deleteSubject(int id) {
		String query = "DELETE FROM subjects WHERE subId = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Subject deleted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
