package com.aurionpro.model;

public class Account {
	private int accountId;
	private String accountHolder;
	private double balance;

	public Account(int accountId, String accountHolder, double balance) {
		this.accountId = accountId;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [ID=" + accountId + ", Holder=" + accountHolder + ", Balance=" + balance + "]";
	}
}