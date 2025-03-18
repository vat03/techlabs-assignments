//package com.aurionpro.bank.service;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.aurionpro.bank.dto.PageResponse;
//import com.aurionpro.bank.dto.UserRequestDto;
//import com.aurionpro.bank.dto.UserResponseDto;
//import com.aurionpro.bank.entity.User;
//import com.aurionpro.bank.repository.UserRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepo;
//
//	private ModelMapper mapper;
//
//	public UserServiceImpl() {
//		this.mapper = new ModelMapper();
//	}
//
//	// Add or update a user
//	@Override
//	public UserResponseDto addUser(UserRequestDto userRequestDto) {
//		User dbUser = userRepo.save(mapper.map(userRequestDto, User.class));
//		return mapper.map(dbUser, UserResponseDto.class);
//	}
//
//	// Get all users with pagination (without Stream API)
//	@Override
//	public PageResponse<UserResponseDto> getAllUsers(int pageNumber, int pageSize) {
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		Page<User> userPage = userRepo.findAll(pageable);
//
//		List<User> dbUsers = userPage.getContent();
//		List<UserResponseDto> userDtos = new ArrayList<>();
//
//		for (User user : dbUsers) {
//			userDtos.add(mapper.map(user, UserResponseDto.class));
//		}
//
//		PageResponse<UserResponseDto> pageResponse = new PageResponse<>();
//		pageResponse.setContent(userDtos);
//		pageResponse.setTotalPages(userPage.getTotalPages());
//		pageResponse.setPageSize(userPage.getSize());
//		pageResponse.setTotalElements(userPage.getTotalElements());
//		pageResponse.setLast(userPage.isLast());
//
//		return pageResponse;
//	}
//
//	// Delete a user by ID
//	@Override
//	public void deleteUser(int userId) {
//		userRepo.deleteById(userId);
//	}
//
//	// Delete all users
//	@Override
//	public void deleteAllUsers() {
//		userRepo.deleteAll();
//	}
//}

package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.dto.UserUpdateRequestDto;
import com.aurionpro.bank.entity.Admin;
import com.aurionpro.bank.entity.Customer;
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.repository.AdminRepository;
import com.aurionpro.bank.repository.CustomerRepository;
import com.aurionpro.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private CustomerRepository customerRepo;

	private ModelMapper mapper;

	public UserServiceImpl() {
		this.mapper = new ModelMapper();
	}

	@Override
	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		User dbUser = mapper.map(userRequestDto, User.class);
		dbUser = userRepo.save(dbUser);

		String userType = userRequestDto.getUserType().toUpperCase();

		if (userType.equals("ADMIN")) {
			Admin admin = new Admin();
			admin.setUser(dbUser);
			adminRepo.save(admin);
		} else if (userType.equals("CUSTOMER")) {
			Customer customer = new Customer();
			customer.setUser(dbUser);
			customerRepo.save(customer);
		}

		return mapper.map(dbUser, UserResponseDto.class);
	}

	@Override
	public UserResponseDto updateUser(int userId, UserUpdateRequestDto userUpdateRequestDto) {
		User existingUser = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		existingUser.setUsername(userUpdateRequestDto.getUsername());
		existingUser.setPassword(userUpdateRequestDto.getPassword());
		existingUser.setEmail(userUpdateRequestDto.getEmail());

		// Do not update userType
		User updatedUser = userRepo.save(existingUser);

		return mapper.map(updatedUser, UserResponseDto.class);
	}

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

	@Override
	public void deactivateUser(int userId) {
		Optional<User> userOptional = userRepo.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setActive(false);
			userRepo.save(user);

			Optional<Admin> adminOpt = adminRepo.findByUserUserId(userId);
			adminOpt.ifPresent(admin -> {
				admin.setActive(false);
				adminRepo.save(admin);
			});

			Optional<Customer> customerOpt = customerRepo.findByUserUserId(userId);
			customerOpt.ifPresent(customer -> {
				customer.setActive(false);
				customerRepo.save(customer);
			});
		}
	}

//	@Override
//	public void deleteAllUsers() {
//		userRepo.deleteAll();
//		adminRepo.deleteAll();
//		customerRepo.deleteAll();
//	}
}