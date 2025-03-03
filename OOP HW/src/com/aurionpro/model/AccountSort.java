package com.aurionpro.model;

import java.util.Random;

public class AccountSort {
	private int accountNumber;
	private String name;
	private double balance;
	private static final double minimumBalance = 500;
	
	//Default Constructor
	public AccountSort()
	{
		this.accountNumber = generateAccountNumber();
	}
	
	//Parameterized Constructor
	public AccountSort(String name, double balance) {
		this.accountNumber = generateAccountNumber();
		this.name = name;
		this.balance = balance;
	}

	
	public int generateAccountNumber()
	{
		Random random = new Random();
		accountNumber = 1000 + random.nextInt(1000);
		return accountNumber;
	}
	
	//Getter methods
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}
	
	public static double getMinimumbalance() {
		return minimumBalance;
	}

	//Setter methods
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}