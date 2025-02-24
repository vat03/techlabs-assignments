package com.aurionpro.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Subjects {
    private Connection connection;

    public Subjects() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Create Subjects
    public void addSubject(String subjectName) {
        String query = "INSERT INTO subjects (subjectName) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subjectName);
            stmt.executeUpdate();
            System.out.println("Subject added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read Subjects
    public List<String> getAllSubjects() {
        List<String> subjects = new ArrayList<>();
        String query = "SELECT * FROM subjects";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                subjects.add("ID: " + rs.getInt("subId") +
                        ", Subject Name: " + rs.getString("subjectName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
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
