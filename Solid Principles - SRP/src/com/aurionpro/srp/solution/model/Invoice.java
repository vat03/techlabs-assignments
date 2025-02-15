package com.aurionpro.srp.solution.model;

public class Invoice {
	private int id;
	private String description;
	private double amount;
	
	public Invoice() {	
		
	}
	
	public Invoice(int id, String description, double amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
