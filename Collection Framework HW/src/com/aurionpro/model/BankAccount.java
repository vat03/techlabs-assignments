package com.aurionpro.model;

public class BankAccount {
	private int accountNumber;
	private String accountHolderName;
	private double balance;

	public BankAccount(int accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + ", Account Holder Name: " + accountHolderName
				+ ", Account Balance: " + balance;
	}
}
