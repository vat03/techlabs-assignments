package com.aurionpro.model;

import java.util.Scanner;

public class Menu {
	public static void runMenu() {
		Scanner scanner = new Scanner(System.in);
		Students studentService = new Students();
		Subjects subjectService = new Subjects();
		Teachers teacherService = new Teachers();
		TeacherSubject teacherSubjectService = new TeacherSubject();
		StudentSubject studentSubjectService = new StudentSubject();

		while (true) {
			System.out.println("\n==== College Management System ====");
			System.out.println("1. Students");
			System.out.println("2. Subjects");
			System.out.println("3. Teachers");
			System.out.println("4. Assign Subject to Teacher");
			System.out.println("5. Enroll Student in Subject");
			System.out.println("6. Exit");
			System.out.print("Choose an entity: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				studentServiceMenu(scanner, studentService);
				break;
			case 2:
				subjectServiceMenu(scanner, subjectService);
				break;
			case 3:
				teacherServiceMenu(scanner, teacherService);
				break;
			case 4: {
				System.out.print("Enter Teacher ID: ");
				int teacherId = scanner.nextInt();
				System.out.print("Enter Subject ID: ");
				int subjectId = scanner.nextInt();
				teacherSubjectService.assignSubjectToTeacher(teacherId, subjectId);
				break;
			}
			case 5: {
				System.out.print("Enter Student ID: ");
				int studentId = scanner.nextInt();
				System.out.print("Enter Subject ID: ");
				int subjectId = scanner.nextInt();
				studentSubjectService.enrollStudentInSubject(studentId, subjectId);
				break;
			}
			case 6: {
				System.out.println("Exiting...");
				scanner.close();
				return;
			}
			default:
				System.out.println("Invalid choice! Try again.");
				break;
			}
		}
	}

	private static void studentServiceMenu(Scanner scanner, Students service) {
		System.out.println("1. Add Student  2. View Students  3. Update Student  4. Delete Student");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter student Id: ");
			int studentId = scanner.nextInt();
			System.out.println("Enter roll number: ");
			int rollNumer = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter name: ");
			String name = scanner.nextLine();
			System.out.println("Enter age: ");
			int age = scanner.nextInt();
			service.addStudent(studentId, rollNumer, name, age);
			break;
		case 2:
			service.getAllStudents();
			break;
		case 3:
			System.out.println("Enter roll number: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter name: ");
			String newName = scanner.nextLine();
			System.out.println("Enter age: ");
			int newAge = scanner.nextInt();
			service.updateStudent(id, newName, newAge);
			break;
		case 4:
			System.out.println("Enter student Id: ");
			id = scanner.nextInt();
			service.deleteStudent(id);
			break;
		default:
			System.out.println("Enter a valid choice !!");
			break;
		}
	}

	private static void subjectServiceMenu(Scanner scanner, Subjects service) {
		System.out.println("1. Add Subject  2. View Subjects  3. Update Subject  4. Delete Subject");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter subject Id: ");
			int subjectId = scanner.nextInt();
			System.out.println("Enter subject name: ");
			scanner.nextLine();
			String subjectName = scanner.nextLine();
			service.addSubject(subjectId, subjectName);
			break;
		case 2:
			service.getAllSubjects();
			break;
		case 3:
			System.out.println("Enter subject Id: ");
			int subId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new Subject name: ");
			String newName = scanner.nextLine();
			service.updateSubject(subId, newName);
			break;
		case 4:
			System.out.println("Enter subject Id: ");
			subId = scanner.nextInt();
			service.deleteSubject(subId);
			break;
		default:
			System.out.println("Enter a valid choice !!");
			break;
		}
	}

	private static void teacherServiceMenu(Scanner scanner, Teachers service) {
		System.out.println("1. Add Teacher  2. View Teachers  3. Update Teacher  4. Delete Teacher");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Teacher Id: ");
			int teacherId = scanner.nextInt();
			System.out.println("Enter Teacher name: ");
			scanner.nextLine();
			String teacherName = scanner.nextLine();
			System.out.println("Enter Qualification: ");
			String qualification = scanner.nextLine();
			service.addTeacher(teacherId, teacherName, qualification);
			break;
		case 2:
			service.getAllTeachers();
			break;
		case 3:
			System.out.println("Enter Teacher Id: ");
			teacherId = scanner.nextInt();
			System.out.println("Enter new Teacher name: ");
			scanner.nextLine();
			teacherName = scanner.nextLine();
			System.out.println("Enter new Qualification: ");
			qualification = scanner.nextLine();
			service.updateTeachers(teacherId, teacherName, qualification);
			break;
		case 4:
			System.out.println("Enter subject Id: ");
			teacherId = scanner.nextInt();
			service.deleteTeacher(teacherId);
			break;
		default:
			System.out.println("Enter a valid choice !!");
			break;
		}
	}
}
