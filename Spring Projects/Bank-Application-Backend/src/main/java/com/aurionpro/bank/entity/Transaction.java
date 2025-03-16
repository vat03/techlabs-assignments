package com.aurionpro.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Transaction {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Column
	private String senderAccountNumber;
	@Column
	private String recieverAccountNumber;
	@Column
	private String transactionType;
	@Column
	private double amount;
	@Column
	private double senderBalanceAfterTransaction;
	@Column
	private double recieverBalanceAfterTransaction;
	@Column
	private boolean status;	
}
