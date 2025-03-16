package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;

public interface UserService {
	UserResponseDto addUser(UserRequestDto userRequestDto);
}
