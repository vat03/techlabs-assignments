package com.aurionpro.bank.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	private ModelMapper mapper;

	public UserServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Add or update a user
	@Override
	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		User dbUser = userRepo.save(mapper.map(userRequestDto, User.class));
		return mapper.map(dbUser, UserResponseDto.class);
	}

	// Get all users with pagination (without Stream API)
	@Override
	public PageResponse<UserResponseDto> getAllUsers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<User> userPage = userRepo.findAll(pageable);

		List<User> dbUsers = userPage.getContent();
		List<UserResponseDto> userDtos = new ArrayList<>();

		for (User user : dbUsers) {
			userDtos.add(mapper.map(user, UserResponseDto.class));
		}

		PageResponse<UserResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(userDtos);
		pageResponse.setTotalPages(userPage.getTotalPages());
		pageResponse.setPageSize(userPage.getSize());
		pageResponse.setTotalElements(userPage.getTotalElements());
		pageResponse.setLast(userPage.isLast());

		return pageResponse;
	}

	// Delete a user by ID
	@Override
	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}

	// Delete all users
	@Override
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}
}
