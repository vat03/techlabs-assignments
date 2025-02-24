package com.aurionpro.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Teachers {
    private Connection connection;

    public Teachers() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Create Teachers
    public void addTeacher(int teacherId, String name, String qualification) {
        String query = "INSERT INTO teachers (teacherId, name, qualification) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, teacherId);
            stmt.setString(2, name);
            stmt.setString(3, qualification);
            stmt.executeUpdate();
            System.out.println("Teacher added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read Teachers
    public List<String> getAllTeachers() {
        List<String> teachers = new ArrayList<>();
        String query = "SELECT * FROM teachers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                teachers.add("ID: " + rs.getInt("teacherId") +
                        ",Teacher Name: " + rs.getString("name") +
                        ", Qualification: " + rs.getString("qualification"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    // Update Teachers
    public void updateTeachers(int id, String name, String qualification) {
        String query = "UPDATE teachers SET name = ?, qualification = ? WHERE teacherId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, qualification);
            stmt.executeUpdate();
            System.out.println("Teacher updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Teachers
    public void deleteTeacher(int id) {
        String query = "DELETE FROM teachers WHERE teacherId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Teacher deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
