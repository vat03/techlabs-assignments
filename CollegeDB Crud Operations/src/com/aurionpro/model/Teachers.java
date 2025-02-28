package com.aurionpro.model;

import java.sql.*;

public class Teachers {
	private Connection connection;

	public Teachers() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void addTeacher(int teacherId, String name, String qualification) {
		String checkQuery = "SELECT COUNT(*) FROM teacher WHERE teacherid = ?";
		try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
			checkStmt.setInt(1, teacherId);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				System.out.println("Teacher ID " + teacherId + " already exists!");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Error checking teacher ID: " + e.getMessage());
			return;
		}

		String query = "INSERT INTO teacher (teacherid, name, qualification) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, teacherId);
			stmt.setString(2, name);
			stmt.setString(3, qualification);
			stmt.executeUpdate();
			System.out.println("Teacher added successfully!");
		} catch (SQLException e) {
			System.out.println("Error adding teacher: " + e.getMessage());
		}
	}

	public void getAllTeachers() {
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {
			while (rs.next()) {
				System.out.printf("TeacherID: %d, Name: %s, Qualification: %s%n", rs.getInt("teacherid"),
						rs.getString("name"), rs.getString("qualification"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving teachers: " + e.getMessage());
		}
	}

	public void updateTeachers(int teacherId, String name, String qualification) {
		String query = "UPDATE teacher SET name = ?, qualification = ? WHERE teacherid = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, name);
			stmt.setString(2, qualification);
			stmt.setInt(3, teacherId);
			stmt.executeUpdate();
			System.out.println("Teacher updated successfully!");
		} catch (SQLException e) {
			System.out.println("Error updating teacher: " + e.getMessage());
		}
	}

	public void deleteTeacher(int teacherId) {
		String query = "DELETE FROM teacher WHERE teacherid = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, teacherId);
			stmt.executeUpdate();
			System.out.println("Teacher deleted successfully!");
		} catch (SQLException e) {
			System.out.println("Error deleting teacher: " + e.getMessage());
		}
	}
}