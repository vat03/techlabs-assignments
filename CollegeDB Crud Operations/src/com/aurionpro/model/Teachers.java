//package com.aurionpro.model;
//
//import java.sql.*;
//
//public class Teachers {
//    private Connection connection;
//
//    public Teachers() {
//        this.connection = DatabaseConnection.getInstance().getConnection();
//    }
//
//    // Create Teachers
//    public void addTeacher(int teacherId, String name, String qualification) {
//        String query = "INSERT INTO teachers (teacherId, name, qualification) VALUES (?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, teacherId);
//            stmt.setString(2, name);
//            stmt.setString(3, qualification);
//            stmt.executeUpdate();
//            System.out.println("Teacher added successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Read Teachers
//    public void getAllTeachers() {
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("Select * from subjects");
//			while (resultSet.next()) {
//				System.out.println(resultSet.getInt("subId") + " " + resultSet.getInt("subjectName") + " "
//						+ resultSet.getString("studentId") + " " + resultSet.getInt("teacherId"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//    // Update Teachers
//    public void updateTeachers(int id, String name, String qualification) {
//        String query = "UPDATE teachers SET name = ?, qualification = ? WHERE teacherId = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, name);
//            stmt.setString(2, qualification);
//            stmt.executeUpdate();
//            System.out.println("Teacher updated successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Delete Teachers
//    public void deleteTeacher(int id) {
//        String query = "DELETE FROM teachers WHERE teacherId = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//            System.out.println("Teacher deleted successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

//package com.aurionpro.model;
//
//import java.sql.*;
//import java.util.logging.*;
//
//public class Teachers {
//	private Connection connection;
//	private static final Logger LOGGER = Logger.getLogger(Teachers.class.getName());
//
//	public Teachers() {
//		this.connection = DatabaseConnection.getInstance().getConnection();
//	}
//
//	public void addTeacher(int teacherId, String name, String qualification) {
//		String query = "INSERT INTO teacher (teacherid, name, qualification) VALUES (?, ?, ?)";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setInt(1, teacherId);
//			stmt.setString(2, name);
//			stmt.setString(3, qualification);
//			stmt.executeUpdate();
//			System.out.println("Teacher added successfully!");
//		} catch (SQLException e) {
//			LOGGER.severe("Error adding teacher: " + e.getMessage());
//		}
//	}
//
//	public void getAllTeachers() {
//		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {
//			while (rs.next()) {
//				System.out.printf("TeacherID: %d, Name: %s, Qualification: %s%n", rs.getInt("teacherid"),
//						rs.getString("name"), rs.getString("qualification"));
//			}
//		} catch (SQLException e) {
//			LOGGER.severe("Error retrieving teachers: " + e.getMessage());
//		}
//	}
//
//	public void updateTeachers(int teacherId, String name, String qualification) {
//		String query = "UPDATE teacher SET name = ?, qualification = ? WHERE teacherid = ?";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setString(1, name);
//			stmt.setString(2, qualification);
//			stmt.setInt(3, teacherId);
//			stmt.executeUpdate();
//			System.out.println("Teacher updated successfully!");
//		} catch (SQLException e) {
//			LOGGER.severe("Error updating teacher: " + e.getMessage());
//		}
//	}
//
//	public void deleteTeacher(int teacherId) {
//		String query = "DELETE FROM teacher WHERE teacherid = ?";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setInt(1, teacherId);
//			stmt.executeUpdate();
//			System.out.println("Teacher deleted successfully!");
//		} catch (SQLException e) {
//			LOGGER.severe("Error deleting teacher: " + e.getMessage());
//		}
//	}
//}

//package com.aurionpro.model;
//
//import java.sql.*;
//
//public class Teachers {
//	private Connection connection;
//
//	public Teachers() {
//		this.connection = DatabaseConnection.getInstance().getConnection();
//	}
//
//	public void addTeacher(int teacherId, String name, String qualification) {
//		String query = "INSERT INTO teacher (teacherid, name, qualification) VALUES (?, ?, ?)";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setInt(1, teacherId);
//			stmt.setString(2, name);
//			stmt.setString(3, qualification);
//			stmt.executeUpdate();
//			System.out.println("Teacher added successfully!");
//		} catch (SQLException e) {
//			System.out.println("Error adding teacher: " + e.getMessage());
//		}
//	}
//
//	public void getAllTeachers() {
//		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {
//			while (rs.next()) {
//				System.out.printf("TeacherID: %d, Name: %s, Qualification: %s%n", rs.getInt("teacherid"),
//						rs.getString("name"), rs.getString("qualification"));
//			}
//		} catch (SQLException e) {
//			System.out.println("Error retrieving teachers: " + e.getMessage());
//		}
//	}
//
//	public void updateTeachers(int teacherId, String name, String qualification) {
//		String query = "UPDATE teacher SET name = ?, qualification = ? WHERE teacherid = ?";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setString(1, name);
//			stmt.setString(2, qualification);
//			stmt.setInt(3, teacherId);
//			stmt.executeUpdate();
//			System.out.println("Teacher updated successfully!");
//		} catch (SQLException e) {
//			System.out.println("Error updating teacher: " + e.getMessage());
//		}
//	}
//
//	public void deleteTeacher(int teacherId) {
//		String query = "DELETE FROM teacher WHERE teacherid = ?";
//		try (PreparedStatement stmt = connection.prepareStatement(query)) {
//			stmt.setInt(1, teacherId);
//			stmt.executeUpdate();
//			System.out.println("Teacher deleted successfully!");
//		} catch (SQLException e) {
//			System.out.println("Error deleting teacher: " + e.getMessage());
//		}
//	}
//}

package com.aurionpro.model;

import java.sql.*;

public class Teachers {
	private Connection connection;

	public Teachers() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void addTeacher(int teacherId, String name, String qualification) {
		String checkQuery = "SELECT COUNT(*) FROM teacher WHERE teacherid = ?";
		try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
			checkStmt.setInt(1, teacherId);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				System.out.println("Teacher ID " + teacherId + " already exists!");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Error checking teacher ID: " + e.getMessage());
			return;
		}

		String query = "INSERT INTO teacher (teacherid, name, qualification) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, teacherId);
			stmt.setString(2, name);
			stmt.setString(3, qualification);
			stmt.executeUpdate();
			System.out.println("Teacher added successfully!");
		} catch (SQLException e) {
			System.out.println("Error adding teacher: " + e.getMessage());
		}
	}

	public void getAllTeachers() {
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {
			while (rs.next()) {
				System.out.printf("TeacherID: %d, Name: %s, Qualification: %s%n", rs.getInt("teacherid"),
						rs.getString("name"), rs.getString("qualification"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving teachers: " + e.getMessage());
		}
	}

	public void updateTeachers(int teacherId, String name, String qualification) {
		String query = "UPDATE teacher SET name = ?, qualification = ? WHERE teacherid = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, name);
			stmt.setString(2, qualification);
			stmt.setInt(3, teacherId);
			stmt.executeUpdate();
			System.out.println("Teacher updated successfully!");
		} catch (SQLException e) {
			System.out.println("Error updating teacher: " + e.getMessage());
		}
	}

	public void deleteTeacher(int teacherId) {
		String query = "DELETE FROM teacher WHERE teacherid = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, teacherId);
			stmt.executeUpdate();
			System.out.println("Teacher deleted successfully!");
		} catch (SQLException e) {
			System.out.println("Error deleting teacher: " + e.getMessage());
		}
	}
}