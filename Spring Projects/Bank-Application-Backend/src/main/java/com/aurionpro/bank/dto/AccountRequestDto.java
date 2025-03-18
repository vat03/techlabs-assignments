package com.aurionpro.bank.dto;

import com.aurionpro.bank.enums.AccountType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class AccountRequestDto {

	@NotBlank(message = "Account number cannot be empty !")
	@Size(min = 6, max = 6, message = "Account number must be characters long !")
	private String accountNumber;

	@Positive(message = "Balance must be positive")
	private double balance;

	@NotNull(message = "Account type cannot be null")
	private AccountType accountType;

	@Positive(message = "Customer ID must be a positive number")
	private int customerId;
}
