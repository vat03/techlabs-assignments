package com.aurionpro.bank.dto;

import lombok.Data;

@Data
public class CustomerResponseDto {

	private int customerId;

	private String firstName;

	private String lastName;
	
	private boolean isActive;

	private UserResponseDto user;
}
