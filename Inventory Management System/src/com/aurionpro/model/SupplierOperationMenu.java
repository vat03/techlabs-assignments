package com.aurionpro.model;

import java.util.Scanner;

public class SupplierOperationMenu {
	private Inventory inventory = new Inventory();
	private Scanner scanner = new Scanner(System.in);

	public void supplierMenu() {
		displaySupplierMenu();
		int choice = scanner.nextInt();
		try {
			switch (choice) {
			case 1:
				addSupplier();
				break;
			case 2:
				updateSupplier();
				break;
			case 3:
				deleteSupplier();
				break;
			case 4:
				viewSupplier();
				break;
			case 5:
				inventory.viewAllSuppliers();
				break;
			case 6:
//				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void displaySupplierMenu() {
		System.out.println("\nSupplier Management");
		System.out.println("1. Add Supplier");
		System.out.println("2. Update Supplier");
		System.out.println("3. Delete Supplier");
		System.out.println("4. View Supplier Details");
		System.out.println("5. View All Suppliers");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
	}

	private void addSupplier() {
		System.out.print("Enter name: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.print("Enter contact info: ");
		String contact = scanner.nextLine();
		inventory.addSupplier(name, contact);
	}

	private void updateSupplier() {
		System.out.print("Enter supplier ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.print("Enter new name: ");
		String name = scanner.nextLine();
		System.out.print("Enter new contact info: ");
		String contact = scanner.nextLine();
		inventory.updateSupplier(id, name, contact);
	}

	private void deleteSupplier() {
		System.out.print("Enter supplier ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		inventory.deleteSupplier(id);
	}

	private void viewSupplier() {
		System.out.print("Enter supplier ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		inventory.viewSupplier(id);
	}
}
