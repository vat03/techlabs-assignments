package com.aurionpro.bank.dto;

import lombok.Data;

@Data
public class AdminResponseDto {

	private int adminId;

	private String firstName;

	private String lastName;
	
	private boolean isActive;

	private UserResponseDto user;
}
