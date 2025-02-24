package com.aurionpro.model;

import java.sql.*;

public class StudentSubject {
    private Connection connection;

    public StudentSubject() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Enroll Student in Subject
    public void enrollStudentInSubject(int studentId, int subjectId) {
        String query = "INSERT INTO student_subject (studentId, subId) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, subjectId);
            stmt.executeUpdate();
            System.out.println("Student enrolled in subject successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
