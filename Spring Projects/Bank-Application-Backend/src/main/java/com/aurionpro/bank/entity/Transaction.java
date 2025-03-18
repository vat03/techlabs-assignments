package com.aurionpro.bank.entity;

import java.time.LocalDateTime;

import com.aurionpro.bank.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Transaction {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@Column
    private LocalDateTime transactionDate = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column
	private TransactionType transactionType;

	@Column
	private double amount;

	@Column
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "senderAccountId")
	private Account senderAccount;

	@ManyToOne
	@JoinColumn(name = "receiverAccountId")
	private Account receiverAccount;
}