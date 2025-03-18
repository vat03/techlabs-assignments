package com.aurionpro.bank.dto;

import com.aurionpro.bank.enums.TransactionType;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionRequestDto {

	@NotNull(message = "Transaction type cannot be null")
	private TransactionType transactionType;

	@Positive(message = "Amount must be positive")
	private double amount;

	@NotNull(message = "Sender account ID cannot be null")
	@Positive(message = "Sender account ID must be a positive number")
	@Digits(integer = 6, fraction = 0, message = "Sender account ID must be a 6-digit number")
	private Integer senderAccountId;

	@NotNull(message = "Receiver account ID cannot be null")
	@Positive(message = "Receiver account ID must be a positive number")
	@Digits(integer = 6, fraction = 0, message = "Receiver account ID must be a 6-digit number")
	private Integer receiverAccountId;
}
