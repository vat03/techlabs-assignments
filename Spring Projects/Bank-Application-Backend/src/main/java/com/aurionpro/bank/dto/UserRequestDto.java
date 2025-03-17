package com.aurionpro.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {
	private int userId;

	@NotBlank(message = "Username cannot be empty !")
	@Size(min = 3, max = 10, message = "Username size must be 3 to 10 characters long !")
	private String username;

	@NotBlank(message = "Password cannot be empty !")
	@Size(min = 8, message = "Password must be atleast 8 characters long !")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
	private String password;

	@NotBlank(message = "Email vannot be empty !")
	@Email(message = "Invalid email format !")
	private String email;

	@NotBlank(message = "User type cannot be empty !")
	@Pattern(regexp = "^(Admin|Customer)$", message = "User type must be either 'Admin' or 'Customer'")
	private String userType;
}
