package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.AdminRequestDto;
import com.aurionpro.bank.dto.AdminResponseDto;
import com.aurionpro.bank.dto.PageResponse;

public interface AdminService {
	PageResponse<AdminResponseDto> getAllAdmins(int pageNumber, int pageSize);

	AdminResponseDto addAdmin(AdminRequestDto adminRequestDto);

	AdminResponseDto updateAdmin(int adminId, AdminRequestDto adminRequestDto);

	void deleteAdmin(int adminId);

	// void deleteAllAdmins();
}
