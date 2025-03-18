package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;

public interface UserService {
	UserResponseDto addUser(UserRequestDto userRequestDto);

	PageResponse<UserResponseDto> getAllUsers(int pageNumber, int pageSize); // Updated for PageResponse

	void deleteUser(int userId);

	void deleteAllUsers();
}
