package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.dto.UserUpdateRequestDto;

public interface UserService {
	UserResponseDto addUser(UserRequestDto userRequestDto);

	UserResponseDto updateUser(int userId, UserUpdateRequestDto userUpdateRequestDto);

	PageResponse<UserResponseDto> getAllUsers(int pageNumber, int pageSize);

	void deactivateUser(int userId);

	// void deleteAllUsers();
}
