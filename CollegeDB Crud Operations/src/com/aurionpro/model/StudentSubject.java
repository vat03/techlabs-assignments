package com.aurionpro.model;

import java.sql.*;

public class StudentSubject {
    private Connection connection;

    public StudentSubject() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Enroll Student in Subject
    public void enrollStudentInSubject(int studentId, int subjectId) {
        
    }
}
