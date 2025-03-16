package com.aurionpro.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class AccountRequestDto {
	private int accountId;
	
	private String accountNumber;

	private double balance;

	private String accountType;
}