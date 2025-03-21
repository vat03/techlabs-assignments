package com.aurionpro.bank.dto;

import java.time.LocalDateTime;

import com.aurionpro.bank.enums.AccountType;

import lombok.Data;

@Data
public class AccountResponseDto {

	private int accountId;

	private String accountNumber;

	private AccountType accountType;
	
	private double balance;

	private LocalDateTime accountCreatedAt;

	private boolean isActive;

	private CustomerResponseDto customer;
}
