package com.aurionpro.bank.service;

import java.util.List;

import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.entity.User;

public interface UserService {
	UserResponseDto addUser(UserRequestDto userRequestDto);
	
	List<UserResponseDto> getAllUsers();

	void deleteUser(User user);
	
	void deleteAllUsers();
}