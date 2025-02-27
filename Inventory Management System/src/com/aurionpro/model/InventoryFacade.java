//package com.aurionpro.model;
//
//import java.util.Scanner;
//
//public class InventoryFacade {
//	private Inventory inventory = new Inventory();
//	private ProductOperationMenu productOperationMenu = new ProductOperationMenu();
//	private SupplierOperationMenu supplierOperationMenu = new SupplierOperationMenu();
//	private TransactionOperationMenu transactionOperationMenu = new TransactionOperationMenu();
//	private Scanner scanner = new Scanner(System.in);
//
//	public void start() {
//		while (true) {
//			displayMenu();
//			int choice = scanner.nextInt();
//			try {
//				switch (choice) {
//				case 1:
//					productOperationMenu.productMenu();
//					break;
//				case 2:
//					supplierOperationMenu.supplierMenu();
//					break;
//				case 3:
//					transactionOperationMenu.transactionMenu();
//					break;
//				case 4:
//					inventory.saveData();
//					break;
//				case 5:
//					inventory.loadData();
//					break;
//				case 6:
//					inventory.generateReports();
//					break;
//				case 7:
//					System.out.println("Exiting");
//					return;
//				default:
//					System.out.println("Invalid choice. Try again.");
//				}
//			} catch (Exception e) {
//				System.out.println("Error: " + e.getMessage());
//			}
//		}
//	}
//
//	private void displayMenu() {
//		System.out.println("\nWelcome to the Inventory Management System");
//		System.out.println("1. Product Management");
//		System.out.println("2. Supplier Management");
//		System.out.println("3. Transaction Management");
//		System.out.println("4. Save Data");
//		System.out.println("5. Load Data");
//		System.out.println("6. Generate Reports");
//		System.out.println("7. Exit");
//		System.out.print("Enter your choice: ");
//	}
//}

package com.aurionpro.model;

import java.util.Scanner;

public class InventoryFacade {
	private Inventory inventory = new Inventory();
	private ProductOperationMenu productOperationMenu;
	private SupplierOperationMenu supplierOperationMenu;
	private TransactionOperationMenu transactionOperationMenu;
	private Scanner scanner = new Scanner(System.in);

	public InventoryFacade() {
		this.productOperationMenu = new ProductOperationMenu(inventory);
		this.supplierOperationMenu = new SupplierOperationMenu(inventory);
		this.transactionOperationMenu = new TransactionOperationMenu(inventory);
	}

	public void start() {
		while (true) {
			displayMenu();
			int choice = scanner.nextInt();
			try {
				switch (choice) {
				case 1:
					productOperationMenu.productMenu();
					break;
				case 2:
					supplierOperationMenu.supplierMenu();
					break;
				case 3:
					transactionOperationMenu.transactionMenu();
					break;
				case 4:
					inventory.saveData();
					break;
				case 5:
					inventory.loadData();
					break;
				case 6:
					inventory.generateReports();
					break;
				case 7:
					System.out.println("Exiting");
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
		System.out.println("\n============================================");
		System.out.println(" Welcome to the Inventory Management System");
		System.out.println("============================================\n");
		System.out.println("1. Product Management");
		System.out.println("2. Supplier Management");
		System.out.println("3. Transaction Management");
		System.out.println("4. Save Data");
		System.out.println("5. Load Data");
		System.out.println("6. Generate Reports");
		System.out.println("7. Exit");
		System.out.print("Enter your choice: ");
	}
}
