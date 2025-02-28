package com.aurionpro.model;

import java.sql.*;

public class StudentSubject {
	private Connection connection;

	public StudentSubject() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void enrollStudentInSubject(int studentId, int subjectId) {
		String query = "INSERT INTO student_subjects (studentId, subid) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, studentId);
			stmt.setInt(2, subjectId);
			stmt.executeUpdate();
			System.out.println("Student enrolled in subject successfully!");
		} catch (SQLException e) {
			System.out.println("Failed to enroll student: " + e.getMessage());
		}
	}
}