package com.aurionpro.model;

public class SavingsAccount extends Account {
	private double interestRate;
	private static final double minimumBalance = 500;

	// Default Constructor
	public SavingsAccount() {

	}

	// Parameterized Constructor
	public SavingsAccount(int accountNumber, String name, double balance, double interestRate) {
		super(accountNumber, name, balance);
		this.interestRate = interestRate;
	}

	// Getter
	public double getInterestRate() {
		return interestRate;
	}

	// Setter
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	// Withdraw method
	public void withdraw(double amount) {
		if (amount > 0 && (balance - amount) >= minimumBalance) {
			balance = balance - amount;
			System.out.println(amount + " withdrawn successfully.");
		} else if (amount < 0) {
			System.out.println("Enter a valid amount.");
		} else if (amount > balance) {
			System.out.println("Insufficient balance !");
		} else {
			System.out.println("Insufficient balance! Minimum balance of " + minimumBalance + " required.");
		}
	}
}
