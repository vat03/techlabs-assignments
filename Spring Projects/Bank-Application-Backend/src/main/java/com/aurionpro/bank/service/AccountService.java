//package com.aurionpro.bank.service;
//
//import java.util.List;
//
//import com.aurionpro.bank.dto.AccountRequestDto;
//import com.aurionpro.bank.dto.AccountResponseDto;
//import com.aurionpro.bank.entity.Account;
//
//public interface AccountService {
//	List<AccountResponseDto> getAllAccounts();
//	
//	AccountResponseDto addAccount(AccountRequestDto accountRequestDto);
//	
//	void deleteAccount(Account account);
//	
//	void deleteAllAccounts();
//}

package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.AccountRequestDto;
import com.aurionpro.bank.dto.AccountResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Account;

public interface AccountService {
	PageResponse<AccountResponseDto> getAllAccounts(int pageNumber, int pageSize);

	AccountResponseDto addAccount(AccountRequestDto accountRequestDto);

	void deleteAccount(Account account);

	void deleteAllAccounts();
}
