package com.aurionpro.bank.dto;

import java.time.LocalDateTime;

import com.aurionpro.bank.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponseDto {

	private int transactionId;
	
	private LocalDateTime transactionDate;
	
	private TransactionType transactionType;
	
	private double amount;
	
	private boolean status;

	private AccountResponseDto senderAccount;
	
	private AccountResponseDto receiverAccount;
}
