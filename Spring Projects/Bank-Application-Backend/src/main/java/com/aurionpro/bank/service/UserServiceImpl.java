package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	private ModelMapper mapper;

	private UserServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Add a user / update a user
	@Override
	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		User dbUser = userRepo.save(mapper.map(userRequestDto, User.class));
		return mapper.map(dbUser, UserResponseDto.class);
	}

	// Get all users
	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserResponseDto> userDto = new ArrayList<>();
		for (User user : users) {
			userDto.add(mapper.map(user, UserResponseDto.class));
		}
		return userDto;
	}

	// Delete a user
	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);
	}

	@Override
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}
	
	
}