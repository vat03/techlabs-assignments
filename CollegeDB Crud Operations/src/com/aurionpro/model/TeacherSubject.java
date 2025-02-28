//package com.aurionpro.model;
//
//import java.sql.*;
//
//public class TeacherSubject {
//	private Connection connection;
//
//	public TeacherSubject() {
//        this.connection = DatabaseConnection.getInstance().getConnection();
//    }
//
//	// Assign Subject to Teacher (One-to-Many)
//	public void assignSubjectToTeacher(int teacherId, int subjectId) {
////		String query = "UPDATE subjects SET teacherId = ? WHERE subId = ?";
//		String query = "INSERT INTO teacher_subject (teacherId, subjectId) VALUES (?, ?)";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setInt(1, teacherId);
//			stmt.setInt(2, subjectId);
//			stmt.executeUpdate();
//			System.out.println("Subject assigned to teacher successfully!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}

//package com.aurionpro.model;
//
//import java.sql.*;
//import java.util.logging.*;
//
//public class TeacherSubject {
//	private Connection connection;
//	private static final Logger LOGGER = Logger.getLogger(TeacherSubject.class.getName());
//
//	public TeacherSubject() {
//		this.connection = DatabaseConnection.getInstance().getConnection();
//	}
//
//	public void assignSubjectToTeacher(int teacherId, int subjectId) {
//		String query = "INSERT INTO teacher_subjects (teacherid, subid) VALUES (?, ?)";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setInt(1, teacherId);
//			stmt.setInt(2, subjectId);
//			stmt.executeUpdate();
//			System.out.println("Subject assigned to teacher successfully!");
//		} catch (SQLException e) {
//			LOGGER.severe("Error assigning subject: " + e.getMessage());
//			System.out.println("Failed to assign subject: " + e.getMessage());
//		}
//	}
//}

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