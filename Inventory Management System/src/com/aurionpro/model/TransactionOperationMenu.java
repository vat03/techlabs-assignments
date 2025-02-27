//package com.aurionpro.model;
//
//import java.util.Scanner;
//
//import com.aurionpro.exceptions.InsufficientStockException;
//
//public class TransactionOperationMenu {
//	private Inventory inventory = new Inventory();
//	private Scanner scanner = new Scanner(System.in);
//
//	public void transactionMenu() {
//		displayTransactionMenu();
//		int choice = scanner.nextInt();
//		try {
//			switch (choice) {
//			case 1:
//				addStock();
//				break;
//			case 2:
//				removeStock();
//				break;
//			case 3:
//				viewTransactionHistory();
//				break;
//			case 4:
////				System.out.println("Exiting...");
//				return;
//			default:
//				System.out.println("Invalid choice. Try again.");
//			}
//		} catch (Exception e) {
//			System.out.println("Error: " + e.getMessage());
//		}
//	}
//
//	private void displayTransactionMenu() {
//		System.out.println("\nTransaction Management");
//		System.out.println("1. Add Stock");
//		System.out.println("2. Remove Stock");
//		System.out.println("3. View Transaction History");
//		System.out.println("4. Exit");
//		System.out.print("Enter your choice: ");
//	}
//
//	private void addStock() throws InsufficientStockException {
//		System.out.print("Enter product ID: ");
//		scanner.nextLine();
//		String id = scanner.nextLine();
//		System.out.print("Enter quantity to add: ");
//		int qty = Integer.parseInt(scanner.nextLine());
//		inventory.addStock(id, qty);
//	}
//
//	private void removeStock() throws InsufficientStockException {
//		System.out.print("Enter product ID: ");
//		scanner.nextLine();
//		String id = scanner.nextLine();
//		System.out.print("Enter quantity to remove: ");
//		int qty = Integer.parseInt(scanner.nextLine());
//		inventory.removeStock(id, qty);
//	}
//
//	private void viewTransactionHistory() {
//		System.out.print("Enter product ID: ");
//		scanner.nextLine();
//		String id = scanner.nextLine();
//		inventory.viewTransactionHistory(id);
//	}
//}

package com.aurionpro.model;

import java.util.Scanner;
import com.aurionpro.exceptions.InsufficientStockException;

public class TransactionOperationMenu {
	private Inventory inventory;
	private Scanner scanner = new Scanner(System.in);

	public TransactionOperationMenu(Inventory inventory) { 
		this.inventory = inventory;
	}

	public void transactionMenu() {
		while (true) { 
			displayTransactionMenu();
			int choice = scanner.nextInt();
			try {
				switch (choice) {
				case 1:
					addStock();
					break;
				case 2:
					removeStock();
					break;
				case 3:
					viewTransactionHistory();
					break;
				case 4:
					return; 
				default:
					System.out.println("Invalid choice. Try again.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void displayTransactionMenu() {
		System.out.println("\n------- Transaction Management -------\n");
		System.out.println("1. Add Stock");
		System.out.println("2. Remove Stock");
		System.out.println("3. View Transaction History");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
	}

	private void addStock() throws InsufficientStockException {
		System.out.print("Enter product ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.print("Enter quantity to add: ");
		int qty = Integer.parseInt(scanner.nextLine());
		inventory.addStock(id, qty);
	}

	private void removeStock() throws InsufficientStockException {
		System.out.print("Enter product ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.print("Enter quantity to remove: ");
		int qty = Integer.parseInt(scanner.nextLine());
		inventory.removeStock(id, qty);
	}

	private void viewTransactionHistory() {
		System.out.print("Enter product ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		inventory.viewTransactionHistory(id);
	}
}
