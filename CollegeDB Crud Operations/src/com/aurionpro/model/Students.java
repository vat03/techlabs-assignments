package com.aurionpro.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private Connection connection;

    public Students() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Create Student
    public void addStudent(int studentId, int rollNumber, String name, int age) {
        String query = "INSERT INTO students (studentId, rollNumber, name, age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
        	stmt.setInt(1, studentId);
            stmt.setInt(2, rollNumber);
            stmt.setString(3, name);
            stmt.setInt(4, age);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read Students
    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add("ID: " + rs.getInt("studentId") +
                        ", Roll: " + rs.getInt("rollNumber") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Update Student
    public void updateStudent(int id, String name, int age) {
        String query = "UPDATE students SET name = ?, age = ? WHERE studentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE studentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
