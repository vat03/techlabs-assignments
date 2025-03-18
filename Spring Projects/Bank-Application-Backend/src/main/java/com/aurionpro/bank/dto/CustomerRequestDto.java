package com.aurionpro.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class CustomerRequestDto {

	@NotBlank(message = "First name cannot be empty !")
	private String firstName;

	@NotBlank(message = "Last name cannot be empty !")
	private String lastName;

	@Positive(message = "User ID must be a positive number !")
	private int userId;
}
