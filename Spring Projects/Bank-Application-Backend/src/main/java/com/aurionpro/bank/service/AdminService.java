//package com.aurionpro.bank.service;
//
//import java.util.List;
//
//import com.aurionpro.bank.dto.AdminRequestDto;
//import com.aurionpro.bank.dto.AdminResponseDto;
//import com.aurionpro.bank.entity.Admin;
//
//public interface AdminService {
//	List<AdminResponseDto> getAllAdmins();
//	
//	AdminResponseDto addAdmin(AdminRequestDto adminRequestDto);
//	
//	void deleteAdmin(Admin admin);
//	
//	void deleteAllAdmins();
//}

package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.AdminRequestDto;
import com.aurionpro.bank.dto.AdminResponseDto;
import com.aurionpro.bank.dto.PageResponse;

public interface AdminService {
	PageResponse<AdminResponseDto> getAllAdmins(int pageNumber, int pageSize);

	AdminResponseDto addAdmin(AdminRequestDto adminRequestDto);

	void deleteAdmin(int adminId);

	void deleteAllAdmins();
}
