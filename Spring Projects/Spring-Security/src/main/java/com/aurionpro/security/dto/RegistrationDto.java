package com.aurionpro.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationDto {
	private String username;
	private String password;
	private String role;
}
