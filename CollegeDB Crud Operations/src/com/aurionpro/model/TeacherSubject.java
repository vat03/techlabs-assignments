package com.aurionpro.model;

import java.sql.*;

public class TeacherSubject {
	private Connection connection;

	public TeacherSubject() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void assignSubjectToTeacher(int teacherId, int subjectId) {
		String query = "INSERT INTO teacher_subjects (teacherid, subid) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, teacherId);
			stmt.setInt(2, subjectId);
			stmt.executeUpdate();
			System.out.println("Subject assigned to teacher successfully!");
		} catch (SQLException e) {
			System.out.println("Failed to assign subject: " + e.getMessage());
		}
	}
}