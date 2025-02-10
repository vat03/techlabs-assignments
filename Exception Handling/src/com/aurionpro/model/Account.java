package com.aurionpro.model;

import com.aurionpro.exception.MinimumBalanceException;
import com.aurionpro.exception.NegativeAmountException;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	private static final double minimumBalance = 500;
	
	// Parameterized Constructor
	public Account(int accountNumber, String name, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		if(balance < minimumBalance)
		{
			throw new MinimumBalanceException();
		}
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
		if(balance < minimumBalance)
		{
			throw new MinimumBalanceException();
		}
		this.balance = balance;
	}

	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			System.out.println(amount + " deposited successfully.");
		} else {
			throw new NegativeAmountException(amount);
		}
	}
	
	public void withdraw(double amount) {
		if (amount > 0 && (balance - amount) >= minimumBalance) {
			balance = balance - amount;
			System.out.println(amount + " withdrawn successfully.");
		} else if (amount < 0) {
			throw new NegativeAmountException(amount);
		} else if (amount > balance) {
			System.out.println("Insufficient balance !");
		} else {
			throw new MinimumBalanceException();
		}
	}
}
