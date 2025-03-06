package com.aurionpro.entity;

import java.sql.Timestamp;

public class TransactionEntity {
	private int transactionId;
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private String transactionType;
	private double amount;
	private double senderBalanceAfter;
	private double receiverBalanceAfter; // New field
	private Timestamp transactionDate;
	private String status;

	public TransactionEntity() {
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(String senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public String getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(String receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getSenderBalanceAfter() {
		return senderBalanceAfter;
	}

	public void setSenderBalanceAfter(double senderBalanceAfter) {
		this.senderBalanceAfter = senderBalanceAfter;
	}

	public double getReceiverBalanceAfter() {
		return receiverBalanceAfter;
	}

	public void setReceiverBalanceAfter(double receiverBalanceAfter) {
		this.receiverBalanceAfter = receiverBalanceAfter;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
