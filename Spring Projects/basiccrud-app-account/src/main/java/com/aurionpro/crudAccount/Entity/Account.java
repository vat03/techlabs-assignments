package com.aurionpro.crudAccount.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
	@Column(name="accountId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	@Column(name="accountNumber")
	private String accountNumber;
	@Column(name="name")
	private String name;
	@Column(name="balance")
	private double balance;

	public Account() {

	}

	public Account(int accountId, String accountNumber, String name, double balance) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [AccountId=" + accountId + ", accountNumber=" + accountNumber + ", Name=" + name + ", balance="
				+ balance + "]";
	}
}
