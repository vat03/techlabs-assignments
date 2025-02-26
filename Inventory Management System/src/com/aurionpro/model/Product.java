package com.aurionpro.model;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productId;
	private String name;
	private String description;
	private int quantity;
	private double price;

	// Constructor
	public Product(String productId, String name, String description, int quantity, double price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	// Getters
	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [ID=" + productId + ", Name=" + name + ", Description=" + description + ", Quantity=" + quantity
				+ ", Price=" + price + "]";
	}
}
