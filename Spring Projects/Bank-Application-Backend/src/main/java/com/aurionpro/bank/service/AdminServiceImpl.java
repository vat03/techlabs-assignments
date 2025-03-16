package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.AdminRequestDto;
import com.aurionpro.bank.dto.AdminResponseDto;
import com.aurionpro.bank.entity.Admin;
import com.aurionpro.bank.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	private ModelMapper mapper;

	private AdminServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all admins
	@Override
	public List<AdminResponseDto> getAllAdmins() {
		List<Admin> admins = adminRepo.findAll();
		List<AdminResponseDto> adminDto = new ArrayList<>();
		for (Admin admin : admins) {
			adminDto.add(mapper.map(admin, AdminResponseDto.class));
		}
		return adminDto;
	}

	// Update admin
	@Override
	public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto) {
		Admin dbAdmin = adminRepo.save(mapper.map(adminRequestDto, Admin.class));
		return mapper.map(dbAdmin, AdminResponseDto.class);
	}

	// delete an admin
	@Override
	public void deleteAdmin(Admin admin) {
		adminRepo.delete(admin);
	}

	// delete all admins
	@Override
	public void deleteAllAdmins() {
		adminRepo.deleteAll();
	}
}
