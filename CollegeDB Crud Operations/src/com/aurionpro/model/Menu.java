package com.aurionpro.model;

import java.util.Scanner;

public class Menu {
	private static DatabaseFacade facade = new DatabaseFacade();

	public static void runMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			displayMainMenu();
			try {
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					studentMenu(scanner);
					break;
				case 2:
					subjectMenu(scanner);
					break;
				case 3:
					teacherMenu(scanner);
					break;
				case 4:
					assignSubjectToTeacher(scanner);
					break;
				case 5:
					enrollStudentInSubject(scanner);
					break;
				case 6:
					searchStudent(scanner);
					break;
				case 7:
					System.out.println("\nThanks for using my Application.");
					System.out.println("Exiting the Application");
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice! Try again.");
				}
			} catch (Exception e) {
				System.out.println("Please enter a valid number!");
				scanner.nextLine();
			}
		}
	}

	private static void displayMainMenu() {
		System.out.println("\n===========================");
		System.out.println(" College Management System ");
		System.out.println("===========================\n");
		System.out.println("1. Manage Students");
		System.out.println("2. Manage Subjects");
		System.out.println("3. Manage Teachers");
		System.out.println("4. Assign Subject to Teacher");
		System.out.println("5. Enroll Student in Subject");
		System.out.println("6. Search Student by Name");
		System.out.println("7. Exit");
		System.out.print("Choose an option: ");
	}

	private static void studentMenu(Scanner scanner) {
		System.out.println("1. Add  2. View All  3. Update  4. Delete");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Enter Student ID: ");
			int studentId = scanner.nextInt();
			System.out.print("Enter Roll Number: ");
			int rollNumber = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter Age: ");
			int age = scanner.nextInt();
			facade.addStudent(studentId, rollNumber, name, age);
			break;
		case 2:
			facade.getAllStudents();
			break;
		case 3:
			System.out.print("Enter Student ID: ");
			studentId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter New Name: ");
			name = scanner.nextLine();
			System.out.print("Enter New Age: ");
			age = scanner.nextInt();
			facade.updateStudent(studentId, name, age);
			break;
		case 4:
			System.out.print("Enter Student ID: ");
			studentId = scanner.nextInt();
			facade.deleteStudent(studentId);
			break;
		default:
			System.out.println("Invalid choice!");
		}
	}

	private static void subjectMenu(Scanner scanner) {
		System.out.println("1. Add  2. View All");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Enter Subject ID: ");
			int subId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Subject Name: ");
			String subName = scanner.nextLine();
			facade.addSubject(subId, subName);
			break;
		case 2:
			facade.getAllSubjects();
			break;
		default:
			System.out.println("Invalid choice!");
		}
	}

	private static void teacherMenu(Scanner scanner) {
		System.out.println("1. Add  2. View All");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Enter Teacher ID: ");
			int teacherId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter Qualification: ");
			String qual = scanner.nextLine();
			facade.addTeacher(teacherId, name, qual);
			break;
		case 2:
			facade.getAllTeachers();
			break;
		default:
			System.out.println("Invalid choice!");
		}
	}

	private static void assignSubjectToTeacher(Scanner scanner) {
		System.out.print("Enter Teacher ID: ");
		int teacherId = scanner.nextInt();
		System.out.print("Enter Subject ID: ");
		int subId = scanner.nextInt();
		facade.assignSubjectToTeacher(teacherId, subId);
	}

	private static void enrollStudentInSubject(Scanner scanner) {
		System.out.print("Enter Student ID: ");
		int studentId = scanner.nextInt();
		System.out.print("Enter Subject ID: ");
		int subId = scanner.nextInt();
		facade.enrollStudentInSubject(studentId, subId);
	}

	private static void searchStudent(Scanner scanner) {
		System.out.print("Enter name to search: ");
		String name = scanner.nextLine();
		facade.searchStudentByName(name);
	}
}