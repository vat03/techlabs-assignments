package com.aurionpro.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

//	public ModelMapper mapper;
//
//	public UserServiceImpl() {
//		this.mapper = new ModelMapper();
//	}

	@Override
	@Transactional
	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		User dbUser = userRepo.save(userRequestDtoToUser(userRequestDto));
		return userToUserResponseDto(dbUser);
	}
	
	public User userRequestDtoToUser(UserRequestDto userRequestDto)
	{
		User user = new User();
		user.setUserId(userRequestDto.getUserId());
		user.setUsername(userRequestDto.getUsername());
		user.setPassword(userRequestDto.getPassword());
		user.setEmail(userRequestDto.getEmail());
		user.setUserType(userRequestDto.getUserType());
		return user;
	}
	
	public UserResponseDto userToUserResponseDto(User user)
	{
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setUsername(user.getUsername());
		userResponseDto.setPassword(user.getPassword());
		userResponseDto.setEmail(user.getEmail());
		userResponseDto.setUserType(user.getUserType());
		return userResponseDto;
	}
}