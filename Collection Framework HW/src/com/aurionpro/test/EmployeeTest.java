package com.aurionpro.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeTest {

	static Map<Integer, String> employee = new HashMap<Integer, String>();

	public static void main(String[] args) {
		takeInput();
	}

	public static void takeInput() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Insert\n2. Update\n3. Delete\n4. Search\n5. Display\n6. Exit");
			System.out.print("Enter the operation you want to perform: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Insert
				insertEmployee(scanner);
				displayAllEmployees();
				break;

			case 2:
				// Update
				updateEmployee(scanner);
				displayAllEmployees();
				break;

			case 3:
				// Delete
				deleteEmployee(scanner);
				displayAllEmployees();
				break;

			case 4:
				// Search
				searchEmployee(scanner);
				break;
			case 5:
				// display
				displayAllEmployees();
				break;
			case 6:
				System.out.println("Thank you !! Exiting the application.");
				scanner.close();
				return;
			default:
				System.out.println("Enter a valid choice !!");
				break;
			}
		}
	}

	static {
		System.out.println("Here are the list of operations you can perform: -");
	}

	public static void insertEmployee(Scanner scanner) {
		System.out.print("Enter Employee ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Employee Name: ");
		String name = scanner.nextLine();

		if (employee.containsKey(id)) {
			System.out.println(
					"Employee ID already exists! Cannot insert with same id. You can use update operation instead.");
		} else {
			employee.put(id, name);
			System.out.println("Employee added successfully.");
		}
	}

	public static void updateEmployee(Scanner scanner) {
		System.out.print("Enter Employee ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		if (employee.containsKey(id)) {
			System.out.print("Enter new Employee Name: ");
			String name = scanner.nextLine();
			employee.put(id, name);
			System.out.println("Employee updated successfully.");
		} else {
			System.out.println("Employee ID not found!");
		}
	}

	public static void deleteEmployee(Scanner scanner) {
		System.out.print("Enter Employee ID to delete: ");
		int id = scanner.nextInt();

		if (employee.containsKey(id)) {
			employee.remove(id);
			System.out.println("Employee deleted successfully.");
		} else {
			System.out.println("Employee ID not found!");
		}
	}

	public static void searchEmployee(Scanner scanner) {
		System.out.print("Enter Employee ID to search: ");
		int id = scanner.nextInt();

		if (employee.containsKey(id)) {
			System.out.println("Employee Found: ID = " + id + ", Name = " + employee.get(id));
		} else {
			System.out.println("Employee ID not found!");
		}
	}

	public static void displayAllEmployees() {
		System.out.println();
		if (employee.isEmpty()) {
			System.out.println("Map is empty !! No employee to show.");
		} else {
			System.out.println("Employee Details:");
			for (Map.Entry<Integer, String> entry : employee.entrySet()) {
				System.out.println("ID: " + entry.getKey() + " -> Name: " + entry.getValue());
			}
		}
	}
}
