package com.aurionpro.model;

import java.sql.*;

public class TeacherSubject {
	private Connection connection;

	public TeacherSubject() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	// Assign Subject to Teacher (One-to-Many)
	public void assignSubjectToTeacher(int teacherId, int subjectId) {
//		String query = "UPDATE subjects SET teacherId = ? WHERE subId = ?";
		String query = "INSERT INTO teacher_subject (teacherId, subjectId) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, teacherId);
			stmt.setInt(2, subjectId);
			stmt.executeUpdate();
			System.out.println("Subject assigned to teacher successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
