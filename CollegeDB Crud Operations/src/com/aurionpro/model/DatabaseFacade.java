//package com.aurionpro.model;
//
//import java.util.logging.*;
//import java.sql.*;
//
//public class DatabaseFacade {
//    private Students students;
//    private Subjects subjects;
//    private Teachers teachers;
//    private StudentSubject studentSubject;
//    private TeacherSubject teacherSubject;
//    private static final Logger LOGGER = Logger.getLogger(DatabaseFacade.class.getName());
//
//    public DatabaseFacade() {
//        students = new Students();
//        subjects = new Subjects();
//        teachers = new Teachers();
//        studentSubject = new StudentSubject();
//        teacherSubject = new TeacherSubject();
//    }
//
//    // Student Operations
//    public void addStudent(int studentId, int rollNumber, String name, int age) {
//        students.addStudent(studentId, rollNumber, name, age);
//    }
//
//    public void getAllStudents() {
//        students.getAllStudents();
//    }
//
//    public void updateStudent(int studentId, String name, int age) {
//        students.updateStudent(studentId, name, age);
//    }
//
//    public void deleteStudent(int studentId) {
//        students.deleteStudent(studentId);
//    }
//
//    // Subject Operations
//    public void addSubject(int subId, String subjectName) {
//        subjects.addSubject(subId, subjectName);
//    }
//
//    public void getAllSubjects() {
//        subjects.getAllSubjects();
//    }
//
//    // Teacher Operations
//    public void addTeacher(int teacherId, String name, String qualification) {
//        teachers.addTeacher(teacherId, name, qualification);
//    }
//
//    public void getAllTeachers() {
//        teachers.getAllTeachers();
//    }
//
//    // Relationship Operations
//    public void enrollStudentInSubject(int studentId, int subId) {
//        studentSubject.enrollStudentInSubject(studentId, subId);
//    }
//
//    public void assignSubjectToTeacher(int teacherId, int subId) {
//        teacherSubject.assignSubjectToTeacher(teacherId, subId);
//    }
//
//    // Bonus: Search functionality
//    public void searchStudentByName(String name) {
//        try {
//            Connection conn = DatabaseConnection.getInstance().getConnection();
//            String query = "SELECT * FROM students WHERE name LIKE ?";
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, "%" + name + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                System.out.printf("StudentID: %d, Roll: %d, Name: %s, Age: %d%n",
//                    rs.getInt("studentId"), rs.getInt("rollnumber"), rs.getString("name"), rs.getInt("age"));
//            }
//        } catch (SQLException e) {
//            LOGGER.severe("Error searching students: " + e.getMessage());
//        }
//    }
//}

package com.aurionpro.model;

import java.sql.*;

public class DatabaseFacade {
	private Students students;
	private Subjects subjects;
	private Teachers teachers;
	private StudentSubject studentSubject;
	private TeacherSubject teacherSubject;

	public DatabaseFacade() {
		students = new Students();
		subjects = new Subjects();
		teachers = new Teachers();
		studentSubject = new StudentSubject();
		teacherSubject = new TeacherSubject();
	}

	public void addStudent(int studentId, int rollNumber, String name, int age) {
		students.addStudent(studentId, rollNumber, name, age);
	}

	public void getAllStudents() {
		students.getAllStudents();
	}

	public void updateStudent(int studentId, String name, int age) {
		students.updateStudent(studentId, name, age);
	}

	public void deleteStudent(int studentId) {
		students.deleteStudent(studentId);
	}

	public void addSubject(int subId, String subjectName) {
		subjects.addSubject(subId, subjectName);
	}

	public void getAllSubjects() {
		subjects.getAllSubjects();
	}

	public void addTeacher(int teacherId, String name, String qualification) {
		teachers.addTeacher(teacherId, name, qualification);
	}

	public void getAllTeachers() {
		teachers.getAllTeachers();
	}

	public void enrollStudentInSubject(int studentId, int subId) {
		studentSubject.enrollStudentInSubject(studentId, subId);
	}

	public void assignSubjectToTeacher(int teacherId, int subId) {
		teacherSubject.assignSubjectToTeacher(teacherId, subId);
	}

	public void searchStudentByName(String name) {
		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();
			String query = "SELECT * FROM students WHERE name LIKE ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.printf("StudentID: %d, Roll: %d, Name: %s, Age: %d%n", rs.getInt("studentId"),
						rs.getInt("rollnumber"), rs.getString("name"), rs.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println("Error searching students: " + e.getMessage());
		}
	}
}