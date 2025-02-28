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
	private ProductManager productManager;

	public TransactionManager(ProductManager productManager) {
		this.productManager = productManager;
	}

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
			System.out.println("No transaction history available for product " + productId + ".");
			return;
		}

		Product product = productManager.getProduct(productId);
		if (product == null) {
			System.out.println("Product " + productId + " not found.");
			return;
		}

		int currentQuantity = product.getQuantity();
		List<String> transactionDetails = new ArrayList<>();

		for (int i = productTransactions.size() - 1; i >= 0; i--) {
			Transaction t = productTransactions.get(i);
			String detail = "Transaction [ID=" + t.getTransactionId() + ", ProductID=" + t.getProductId() + ", Type="
					+ t.getType() + ", Quantity=" + t.getQuantity() + ", Total Quantity=" + currentQuantity + ", Date="
					+ t.getDate() + "]";
			transactionDetails.add(0, detail);

			if (t.getType().equals("ADD")) {
				currentQuantity -= t.getQuantity();
			} else if (t.getType().equals("REMOVE")) {
				currentQuantity += t.getQuantity();
			}
		}

		transactionDetails.forEach(t -> System.out.println(t));
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}