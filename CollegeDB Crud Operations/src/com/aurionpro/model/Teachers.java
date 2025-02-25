package com.aurionpro.model;

import java.sql.*;

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
    public void getAllTeachers() {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from subjects");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("subId") + " " + resultSet.getInt("subjectName") + " "
						+ resultSet.getString("studentId") + " " + resultSet.getInt("teacherId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
