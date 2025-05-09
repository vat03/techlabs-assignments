package com.aurionpro.model;

public class CurrentAccount extends Account {
	private double overdraftLimit;

	// Default Constructor
	public CurrentAccount() {

	}

	// Parameterized Constructor
	public CurrentAccount(int accountNumber, String name, double balance, double overdraftLimit) {
		super(accountNumber, name, balance);
		this.overdraftLimit = overdraftLimit;
	}

	// Getter
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	// Setter
	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	// Withdraw method
	public void withdraw(double amount) {
		if (amount > 0 && (balance - amount) >= -overdraftLimit) {
			balance = balance - amount;
			System.out.println(amount + " withdrawn successfully.");
		} else if (amount < 0) {
			System.out.println("Enter a valid amount.");
		} else {
			System.out.println("Overdraft limit Crossed! Maximum overdraft allowed: " + overdraftLimit);
		}
	}
}
