package com.aurionpro.model;

import java.sql.*;

public class TeacherSubject {
    private Connection connection;

    public TeacherSubject() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Assign Subject to Teacher (One-to-Many)
    public void assignSubjectToTeacher(int teacherId, int subjectId) {
        
    }
}
