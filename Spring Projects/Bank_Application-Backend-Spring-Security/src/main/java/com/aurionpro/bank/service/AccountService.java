package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.AccountRequestDto;
import com.aurionpro.bank.dto.AccountResponseDto;
import com.aurionpro.bank.dto.PageResponse;

public interface AccountService {
	PageResponse<AccountResponseDto> getAllAccounts(int pageNumber, int pageSize);

	AccountResponseDto addAccount(AccountRequestDto accountRequestDto);

	AccountResponseDto updateAccount(int accountId, AccountRequestDto accountRequestDto);

	void deleteAccount(int accountId);

	// void deleteAllAccounts();
}
