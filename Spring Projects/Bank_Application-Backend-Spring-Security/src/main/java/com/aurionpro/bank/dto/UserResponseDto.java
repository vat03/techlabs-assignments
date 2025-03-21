package com.aurionpro.bank.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserResponseDto {

	private int userId;

	private String username;

	private String email;

	private LocalDateTime userCreatedAt;

	private boolean isActive;
	
	private String userType;
}
