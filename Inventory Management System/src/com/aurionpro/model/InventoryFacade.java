package com.aurionpro.model;

import java.util.Scanner;

import com.aurionpro.exceptions.InsufficientStockException;

public class InventoryFacade {
	private Inventory inventory = new Inventory();
	private Scanner scanner = new Scanner(System.in);

	public void start() {
		while (true) {
			displayMenu();
			String choice = scanner.nextLine();
			try {
				switch (choice) {
				case "1.1":
					addProduct();
					break;
				case "1.2":
					updateProduct();
					break;
				case "1.3":
					deleteProduct();
					break;
				case "1.4":
					viewProduct();
					break;
				case "1.5":
					inventory.viewAllProducts();
					break;
				case "2.1":
					addSupplier();
					break;
				case "2.2":
					updateSupplier();
					break;
				case "2.3":
					deleteSupplier();
					break;
				case "2.4":
					viewSupplier();
					break;
				case "2.5":
					inventory.viewAllSuppliers();
					break;
				case "3.1":
					addStock();
					break;
				case "3.2":
					removeStock();
					break;
				case "3.3":
					viewTransactionHistory();
					break;
				case "4":
					inventory.saveData();
					break;
				case "5":
					inventory.loadData();
					break;
				case "6":
					inventory.generateReports();
					break;
				case "7":
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice. Try again.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void displayMenu() {
		System.out.println("\nWelcome to the Inventory Management System");
		System.out.println("1. Product Management");
		System.out.println("    1.1 Add Product");
		System.out.println("    1.2 Update Product");
		System.out.println("    1.3 Delete Product");
		System.out.println("    1.4 View Product Details");
		System.out.println("    1.5 View All Products");
		System.out.println("2. Supplier Management");
		System.out.println("    2.1 Add Supplier");
		System.out.println("    2.2 Update Supplier");
		System.out.println("    2.3 Delete Supplier");
		System.out.println("    2.4 View Supplier Details");
		System.out.println("    2.5 View All Suppliers");
		System.out.println("3. Transaction Management");
		System.out.println("    3.1 Add Stock");
		System.out.println("    3.2 Remove Stock");
		System.out.println("    3.3 View Transaction History");
		System.out.println("4. Save Data");
		System.out.println("5. Load Data");
		System.out.println("6. Generate Reports");
		System.out.println("7. Exit");
		System.out.print("Enter your choice: ");
	}

	private void addProduct() {
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter description: ");
		String desc = scanner.nextLine();
		System.out.print("Enter quantity: ");
		int qty = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter price: ");
		double price = Double.parseDouble(scanner.nextLine());
		inventory.addProduct(name, desc, qty, price);
	}

	private void updateProduct() {
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter new name: ");
		String name = scanner.nextLine();
		System.out.print("Enter new description: ");
		String desc = scanner.nextLine();
		System.out.print("Enter new quantity: ");
		int qty = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new price: ");
		double price = Double.parseDouble(scanner.nextLine());
		inventory.updateProduct(id, name, desc, qty, price);
	}

	private void deleteProduct() {
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		inventory.deleteProduct(id);
	}

	private void viewProduct() {
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		inventory.viewProduct(id);
	}

	private void addSupplier() {
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter contact info: ");
		String contact = scanner.nextLine();
		inventory.addSupplier(name, contact);
	}

	private void updateSupplier() {
		System.out.print("Enter supplier ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter new name: ");
		String name = scanner.nextLine();
		System.out.print("Enter new contact info: ");
		String contact = scanner.nextLine();
		inventory.updateSupplier(id, name, contact);
	}

	private void deleteSupplier() {
		System.out.print("Enter supplier ID: ");
		String id = scanner.nextLine();
		inventory.deleteSupplier(id);
	}

	private void viewSupplier() {
		System.out.print("Enter supplier ID: ");
		String id = scanner.nextLine();
		inventory.viewSupplier(id);
	}

	private void addStock() throws InsufficientStockException {
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter quantity to add: ");
		int qty = Integer.parseInt(scanner.nextLine());
		inventory.addStock(id, qty);
	}

	private void removeStock() throws InsufficientStockException {
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter quantity to remove: ");
		int qty = Integer.parseInt(scanner.nextLine());
		inventory.removeStock(id, qty);
	}

	private void viewTransactionHistory() {
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		inventory.viewTransactionHistory(id);
	}
}
