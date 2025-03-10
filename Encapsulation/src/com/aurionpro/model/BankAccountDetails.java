package com.aurionpro.model;

public class BankAccountDetails {
	private long accountNumber;
	private String holderName;
	private double balance;

	// default constructor
	public BankAccountDetails()
	{
		System.out.println("Default constructor");
	}
	 // parameterized constructor
	public BankAccountDetails(long accountNumber, String holderName, double balance)
	{
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	// Getter setter methods
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	// Method to deposit
	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			System.out.println("Deposit successful.");
		} else {
			System.out.println("Enter a valid deposit amount.");
		}
	}

	//Method for withdrawal
	public void withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance = balance - amount;
			System.out.println("Withdrawal successful.");
		} else if (amount > balance) {
			System.out.println("Insufficient balance.");
		} else {
			System.out.println("Enter a valid withdrawal amount");
		}
	}

	
	//method for display
	public void displayBalance() {
		System.out.println("Balance: " + balance);
	}
}
