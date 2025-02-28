package com.aurionpro.model;

import java.sql.*;

public class Subjects {
	private Connection connection;

	public Subjects() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void addSubject(int subId, String subjectName) {
		String checkQuery = "SELECT COUNT(*) FROM subjects WHERE subid = ?";
		try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
			checkStmt.setInt(1, subId);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				System.out.println("Subject ID " + subId + " already exists!");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Error checking subject ID: " + e.getMessage());
			return;
		}

		String query = "INSERT INTO subjects (subid, subjectname) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subId);
			stmt.setString(2, subjectName);
			stmt.executeUpdate();
			System.out.println("Subject added successfully!");
		} catch (SQLException e) {
			System.out.println("Error adding subject: " + e.getMessage());
		}
	}

	public void getAllSubjects() {
		try (Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM subjects")) {
			while (rs.next()) {
				System.out.printf("SubjectID: %d, Name: %s%n", rs.getInt("subid"), rs.getString("subjectname"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving subjects: " + e.getMessage());
		}
	}

	public void updateSubject(int subId, String name) {
		String query = "UPDATE subjects SET subjectname = ? WHERE subid = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subId);
			stmt.setString(2, name);
			stmt.executeUpdate();
			System.out.println("Subject updated successfully!");
		} catch (SQLException e) {
			System.out.println("Error updating subject: " + e.getMessage());
		}
	}

	public void deleteSubject(int subId) {
		String query = "DELETE FROM subjects WHERE subid = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subId);
			stmt.executeUpdate();
			System.out.println("Subject deleted successfully!");
		} catch (SQLException e) {
			System.out.println("Error deleting subject: " + e.getMessage());
		}
	}
}