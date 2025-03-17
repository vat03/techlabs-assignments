package com.aurionpro.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TransactionRequestDto {
	private int transactionId;

	@NotBlank(message = "Sender account number cannot be empty")
    @Size(min = 6, max = 6, message = "Sender account number must be 6 digits long !")
	private String senderAccountNumber;

	@NotBlank(message = "Reciever account number cannot be empty")
    @Size(min = 6, max = 6, message = "Reciever account number must be 6 digits long !")
	private String recieverAccountNumber;

	@NotBlank(message = "Transaction type cannot be empty")
	@Pattern(regexp = "Transfer|Credit|Debit", message = "Transaction type must be either Transfer or Credit or Debit")
	private String transactionType;

	@Positive(message = "Amount must be greater than 0")
	private double amount;

	@Positive(message = "Sender's balance after transaction cannot be negative")
	private double senderBalanceAfterTransaction;

	@Positive(message = "Reciever's balance after transaction cannot be negative")
	private double recieverBalanceAfterTransaction;

	@NotNull(message = "Transaction status cannot be null")
	private boolean status;	
}
