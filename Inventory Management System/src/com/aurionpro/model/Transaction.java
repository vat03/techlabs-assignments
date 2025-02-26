package com.aurionpro.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private String transactionId;
	private String productId;
	private String type;
	private int quantity;
	private LocalDateTime date;

	// Constructor
	public Transaction(String transactionId, String productId, String type, int quantity) {
		this.transactionId = transactionId;
		this.productId = productId;
		this.type = type;
		this.quantity = quantity;
		this.date = LocalDateTime.now();
	}

	// Getters
	public String getTransactionId() {
		return transactionId;
	}

	public String getProductId() {
		return productId;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public LocalDateTime getDate() {
		return date;
	}

	// Setters
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [ID=" + transactionId + ", ProductID=" + productId + ", Type=" + type + ", Quantity="
				+ quantity + ", Date=" + date + "]";
	}
}
