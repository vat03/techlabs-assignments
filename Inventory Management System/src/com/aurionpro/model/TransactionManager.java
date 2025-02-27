package com.aurionpro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.exceptions.InsufficientStockException;

public class TransactionManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Transaction> transactions = new ArrayList<>();
	private static int idCounter = 0;

	private String generateId(String prefix) {
		return prefix + (++idCounter);
	}

	public void addStock(Product product, String productId, int quantity) throws InsufficientStockException {
		if (product == null)
			throw new IllegalArgumentException("Product not found.");
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity must be positive.");
		product.setQuantity(product.getQuantity() + quantity);
		String id = generateId("T");
		transactions.add(new Transaction(id, productId, "ADD", quantity));
		System.out.println("Stock added: " + quantity + " to " + productId);
	}

	public void removeStock(Product product, String productId, int quantity) throws InsufficientStockException {
		if (product == null)
			throw new IllegalArgumentException("Product not found.");
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity must be positive.");
		if (product.getQuantity() < quantity)
			throw new InsufficientStockException("Insufficient stock for " + productId);
		product.setQuantity(product.getQuantity() - quantity);
		String id = generateId("T");
		transactions.add(new Transaction(id, productId, "REMOVE", quantity));
		System.out.println("Stock removed: " + quantity + " from " + productId);
	}

	public void viewTransactionHistory(String productId) {
		List<Transaction> productTransactions = transactions.stream().filter(t -> t.getProductId().equals(productId))
				.collect(Collectors.toList());
		if (productTransactions.isEmpty()) {
			System.out.println("No Transaction history for product " + productId + ".");
		} else {
			productTransactions.forEach(t -> System.out.println(t));
		}

	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
