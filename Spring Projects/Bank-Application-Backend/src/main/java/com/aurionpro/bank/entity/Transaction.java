package com.aurionpro.bank.entity;

import java.time.LocalDateTime;

import com.aurionpro.bank.enums.TransactionType;

import jakarta.persistence.*;
import lombok.*;

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
	private boolean status = false; 

	@ManyToOne
	@JoinColumn(name = "senderAccountId")
	private Account senderAccount;

	@ManyToOne
	@JoinColumn(name = "receiverAccountId")
	private Account receiverAccount;
}