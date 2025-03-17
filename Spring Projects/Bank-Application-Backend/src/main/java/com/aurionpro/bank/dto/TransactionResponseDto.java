package com.aurionpro.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponseDto {
	private String senderAccountNumber;

	private String recieverAccountNumber;

	private String transactionType;

	private double amount;

	private double senderBalanceAfterTransaction;

	private double recieverBalanceAfterTransaction;

	private boolean status;
}
