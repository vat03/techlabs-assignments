package com.aurionpro.srp.violation.model;

public class Invoice {
	private int id;
	private String description;
	private double amount;
	private double tax;

	public static final double taxPercent = 10;

	public Invoice() {

	}

	public Invoice(int id, String description, double amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double calculateTax(double amount, double taxPercent) {
		tax = (amount * taxPercent) / 100;
		return tax;
	}

	public void printInvoice() {
		System.out.println("\nYour Invoice: ");
		System.out.println("Id: " + id);
		System.out.println("Description: " + description);
		System.out.println("Amount: " + amount);
		System.out.println("Tax: " + tax);
		System.out.println("Total Amount: " + (amount + tax));
	}
}
