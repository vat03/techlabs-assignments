package com.aurionpro.model;

public abstract class Account {
	private int accountNumber;
	private String name;
	protected double balance;

	// Default Constructor
	public Account() {

	}

	// Parameterized Constructor
	public Account(int accountNumber, String name, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	// Getters
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	// Setters
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Deposit method
	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			System.out.println(amount + " deposited successfully.");
		} else {
			System.out.println("Enter a valid deposit amount.");
		}
	}

	// Withdraw method
	public abstract void withdraw(double amount);
}
