package com.aurionpro.bank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CustomerRequestDto {
	private int customerId;

	@NotBlank(message = "First name cannot be empty !")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be empty !")
	private String lastName;
}
