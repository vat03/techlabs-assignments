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
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.bank.dto.AdminRequestDto;
import com.aurionpro.bank.dto.AdminResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Admin;
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.repository.AdminRepository;
import com.aurionpro.bank.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private UserRepository userRepo;

	private ModelMapper mapper;

	public AdminServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all active admins with pagination
	@Override
	public PageResponse<AdminResponseDto> getAllAdmins(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Admin> adminPage = adminRepo.findByIsActive(true, pageable);

		List<Admin> dbAdmins = adminPage.getContent();
		List<AdminResponseDto> adminDtos = new ArrayList<>();

		for (Admin admin : dbAdmins) {
			adminDtos.add(mapper.map(admin, AdminResponseDto.class));
		}

		PageResponse<AdminResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(adminDtos);
		pageResponse.setTotalPages(adminPage.getTotalPages());
		pageResponse.setPageSize(adminPage.getSize());
		pageResponse.setTotalElements(adminPage.getTotalElements());
		pageResponse.setLast(adminPage.isLast());

		return pageResponse;
	}

	// Add an admin and link to existing user
	@Override
	public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto) {
		Optional<User> userOptional = userRepo.findById(adminRequestDto.getUserId());
		if (userOptional.isEmpty()) {
			throw new RuntimeException("User not found with ID: " + adminRequestDto.getUserId());
		}

		User user = userOptional.get();
		Admin admin = new Admin();
		admin.setFirstName(adminRequestDto.getFirstName());
		admin.setLastName(adminRequestDto.getLastName());
		admin.setUser(user);
		admin.setActive(true);

		Admin savedAdmin = adminRepo.save(admin);
		return mapper.map(savedAdmin, AdminResponseDto.class);
	}

	@Override
	public AdminResponseDto updateAdmin(int adminId, AdminRequestDto adminRequestDto) {
		Admin existingAdmin = adminRepo.findById(adminId)
				.orElseThrow(() -> new RuntimeException("Admin not found with ID: " + adminId));

		existingAdmin.setFirstName(adminRequestDto.getFirstName());
		existingAdmin.setLastName(adminRequestDto.getLastName());

		Admin updatedAdmin = adminRepo.save(existingAdmin);

		return mapper.map(updatedAdmin, AdminResponseDto.class);
	}

	// Soft delete an admin and its associated user
	@Override
	@Transactional
	public void deleteAdmin(int adminId) {
		Optional<Admin> adminOptional = adminRepo.findById(adminId);
		if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			admin.setActive(false);

			User user = admin.getUser();
			if (user != null) {
				user.setActive(false);
				userRepo.save(user);
			}

			adminRepo.save(admin);
		} else {
			throw new RuntimeException("Admin not found with ID: " + adminId);
		}
	}

//	@Override
//	@Transactional
//	public void deleteAllAdmins() {
//		List<Admin> admins = adminRepo.findAll();
//		for (Admin admin : admins) {
//			admin.setActive(false);
//			if (admin.getUser() != null) {
//				admin.getUser().setActive(false);
//				userRepo.save(admin.getUser());
//			}
//			adminRepo.save(admin);
//		}
//	}
}