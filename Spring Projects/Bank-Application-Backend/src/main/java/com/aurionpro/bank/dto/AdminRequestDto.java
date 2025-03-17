package com.aurionpro.bank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class AdminRequestDto {
	private int adminId;

	@NotBlank(message = "First name cannot be empty !")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be empty !")
	private String lastName;
}
