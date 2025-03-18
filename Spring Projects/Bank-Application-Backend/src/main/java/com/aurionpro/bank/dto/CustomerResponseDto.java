package com.aurionpro.bank.dto;

import lombok.Data;

@Data
public class CustomerResponseDto {

	private int customerId;

	private String firstName;

	private String lastName;

	private UserResponseDto user;
}
