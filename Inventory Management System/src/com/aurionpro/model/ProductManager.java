package com.aurionpro.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ProductManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Product> products = new HashMap<>();
	private static int idCounter = 0;

	private String generateId(String prefix) {
		return prefix + (++idCounter);
	}

	public void addProduct(String name, String description, int quantity, double price)
			throws IllegalArgumentException {
		if (quantity < 0 || price < 0)
			throw new IllegalArgumentException("Quantity and price must be non-negative.");
		String id = generateId("P");
		products.put(id, new Product(id, name, description, quantity, price));
		System.out.println("Product added: " + id);
	}

	public void updateProduct(String productId, String name, String description, int quantity, double price) {
		Product product = products.get(productId);
		if (product == null)
			throw new IllegalArgumentException("Product not found.");
		product.setName(name);
		product.setDescription(description);
		product.setQuantity(quantity);
		product.setPrice(price);
		System.out.println("Product updated: " + productId);
	}

	public void deleteProduct(String productId) {
		if (products.remove(productId) != null) {
			System.out.println("Product deleted: " + productId);
		} else {
			throw new IllegalArgumentException("Product not found.");
		}
	}

	public void viewProduct(String productId) {
		Product product = products.get(productId);
		if (product != null) {
			System.out.println(product);
		} else {
			System.out.println("Product not found.");
		}
	}

	public void viewAllProducts() {
		for (Product product : products.values()) {
	        System.out.println(product);
	    }
	}

	public Product getProduct(String productId) {
		return products.get(productId);
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}
}
