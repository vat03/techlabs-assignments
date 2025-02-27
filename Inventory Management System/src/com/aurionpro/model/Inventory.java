package com.aurionpro.model;

import java.io.*;
import java.util.List;
import java.util.Map;

import com.aurionpro.exceptions.InsufficientStockException;

public class Inventory {
	private ProductManager productManager = new ProductManager();
	private SupplierManager supplierManager = new SupplierManager();
	private TransactionManager transactionManager = new TransactionManager();

	// Product Management Delegation
	public void addProduct(String name, String description, int quantity, double price)
			throws IllegalArgumentException {
		productManager.addProduct(name, description, quantity, price);
	}

	public void updateProduct(String productId, String name, String description, int quantity, double price) {
		productManager.updateProduct(productId, name, description, quantity, price);
	}

	public void deleteProduct(String productId) {
		productManager.deleteProduct(productId);
	}

	public void viewProduct(String productId) {
		productManager.viewProduct(productId);
	}

	public void viewAllProducts() {
		productManager.viewAllProducts();
	}

	// Supplier Management Delegation
	public void addSupplier(String name, String contactInfo) {
		supplierManager.addSupplier(name, contactInfo);
	}

	public void updateSupplier(String supplierId, String name, String contactInfo) {
		supplierManager.updateSupplier(supplierId, name, contactInfo);
	}

	public void deleteSupplier(String supplierId) {
		supplierManager.deleteSupplier(supplierId);
	}

	public void viewSupplier(String supplierId) {
		supplierManager.viewSupplier(supplierId);
	}

	public void viewAllSuppliers() {
		supplierManager.viewAllSuppliers();
	}

	// Transaction Management Delegation
	public void addStock(String productId, int quantity) throws InsufficientStockException {
		Product product = productManager.getProduct(productId);
		transactionManager.addStock(product, productId, quantity);
	}

	public void removeStock(String productId, int quantity) throws InsufficientStockException {
		Product product = productManager.getProduct(productId);
		transactionManager.removeStock(product, productId, quantity);
	}

	public void viewTransactionHistory(String productId) {
		transactionManager.viewTransactionHistory(productId);
	}

	// File I/O
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory.dat"))) {
			oos.writeObject(productManager.getProducts());
			oos.writeObject(supplierManager.getSuppliers());
			oos.writeObject(transactionManager.getTransactions());
			System.out.println("Data saved successfully.");
		} catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadData() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inventory.dat"))) {
			productManager.setProducts((Map<String, Product>) ois.readObject());
			supplierManager.setSuppliers((Map<String, Supplier>) ois.readObject());
			transactionManager.setTransactions((List<Transaction>) ois.readObject());
			System.out.println("Data loaded successfully.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading data: " + e.getMessage());
		}
	}

	// Report
	public void generateReports() {
		System.out.println("\n=== Inventory Summary Report ===");
		int totalProducts = productManager.getProducts().size();
		System.out.println("Total Number of Products: " + totalProducts);
		if (totalProducts == 0) {
			System.out.println("No products available.");
			return;
		}
		double grandTotalValue = 0.0;
		int productNumber = 1;
		for (Product product : productManager.getProducts().values()) {
			double totalValue = product.getQuantity() * product.getPrice();
			grandTotalValue += totalValue;
			System.out.println("\nProduct " + productNumber + " ID: " + product.getProductId());
			System.out.println("Product " + productNumber + " Name: " + product.getName());
			System.out.println("Product " + productNumber + " Quantity: " + product.getQuantity());
			System.out.println("Product " + productNumber + " Price: Rs." + product.getPrice());
			System.out.println("Product " + productNumber + " Total Value: Rs." + totalValue);
			productNumber++;
		}
		System.out.println("\nTotal Value of All Products: Rs." + grandTotalValue);
	}

}
