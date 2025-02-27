//package com.aurionpro.model;
//
//import java.util.Scanner;
//
//public class ProductOperationMenu {
//	private Inventory inventory = new Inventory();
//	private Scanner scanner = new Scanner(System.in);
//
//	public void productMenu() {
//		displayProductMenu();
//		int choice = scanner.nextInt();
//		try {
//			switch (choice) {
//			case 1:
//				addProduct();
//				break;
//			case 2:
//				updateProduct();
//				break;
//			case 3:
//				deleteProduct();
//				break;
//			case 4:
//				viewProduct();
//				break;
//			case 5:
//				inventory.viewAllProducts();
//				break;
//			case 6:
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
//	private void displayProductMenu() {
//		System.out.println("\nProduct Management");
//		System.out.println("1. Add Product");
//		System.out.println("2. Update Product");
//		System.out.println("3. Delete Product");
//		System.out.println("4. View Product Details");
//		System.out.println("5. View All Products");
//		System.out.println("6. Exit");
//		System.out.print("Enter your choice: ");
//	}
//
//	private void addProduct() {
//		System.out.print("Enter name: ");
//		scanner.nextLine();
//		String name = scanner.nextLine();
//		System.out.print("Enter description: ");
//		String desc = scanner.nextLine();
//		System.out.print("Enter quantity: ");
//		int qty = Integer.parseInt(scanner.nextLine());
//		System.out.print("Enter price: ");
//		double price = Double.parseDouble(scanner.nextLine());
//		inventory.addProduct(name, desc, qty, price);
//	}
//
//	private void updateProduct() {
//		System.out.print("Enter product ID: ");
//		scanner.nextLine();
//		String id = scanner.nextLine();
//		System.out.print("Enter new name: ");
//		String name = scanner.nextLine();
//		System.out.print("Enter new description: ");
//		String desc = scanner.nextLine();
//		System.out.print("Enter new quantity: ");
//		int qty = Integer.parseInt(scanner.nextLine());
//		System.out.print("Enter new price: ");
//		double price = Double.parseDouble(scanner.nextLine());
//		inventory.updateProduct(id, name, desc, qty, price);
//	}
//
//	private void deleteProduct() {
//		System.out.print("Enter product ID: ");
//		scanner.nextLine();
//		String id = scanner.nextLine();
//		inventory.deleteProduct(id);
//	}
//
//	private void viewProduct() {
//		System.out.print("Enter product ID: ");
//		scanner.nextLine();
//		String id = scanner.nextLine();
//		inventory.viewProduct(id);
//	}
//}

package com.aurionpro.model;

import java.util.Scanner;

public class ProductOperationMenu {
	private Inventory inventory;
	private Scanner scanner = new Scanner(System.in);

	public ProductOperationMenu(Inventory inventory) { 
		this.inventory = inventory;
	}

	public void productMenu() {
		while (true) {
			displayProductMenu();
			int choice = scanner.nextInt();
			try {
				switch (choice) {
				case 1:
					addProduct();
					break;
				case 2:
					updateProduct();
					break;
				case 3:
					deleteProduct();
					break;
				case 4:
					viewProduct();
					break;
				case 5:
					inventory.viewAllProducts();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice. Try again.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void displayProductMenu() {
		System.out.println("\n------- Product Management -------\n");
		System.out.println("1. Add Product");
		System.out.println("2. Update Product");
		System.out.println("3. Delete Product");
		System.out.println("4. View Product Details");
		System.out.println("5. View All Products");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
	}

	private void addProduct() {
		System.out.print("Enter name: ");
		scanner.nextLine(); // Clear buffer
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
		scanner.nextLine();
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
		scanner.nextLine();
		String id = scanner.nextLine();
		inventory.deleteProduct(id);
	}

	private void viewProduct() {
		System.out.print("Enter product ID: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		inventory.viewProduct(id);
	}
}
