//package com.aurionpro.bank.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.aurionpro.bank.dto.AccountRequestDto;
//import com.aurionpro.bank.dto.AccountResponseDto;
//import com.aurionpro.bank.entity.Account;
//import com.aurionpro.bank.repository.AccountRepository;
//
//@Service
//public class AccountServiceImpl implements AccountService{
//
//	@Autowired
//	private AccountRepository accountRepo;
//	
//	private ModelMapper mapper;
//	
//	private AccountServiceImpl()
//	{
//		this.mapper = new ModelMapper();
//	}
//	
//	// get all accounts
//	@Override
//	public List<AccountResponseDto> getAllAccounts() {
//		List<Account> accounts = accountRepo.findAll();
//		List<AccountResponseDto> accountDto = new ArrayList<>();
//		for (Account account : accounts) {
//			accountDto.add(mapper.map(account, AccountResponseDto.class));
//		}
//		
//		return accountDto;
//	}
//
//	// add account
//	@Override
//	public AccountResponseDto addAccount(AccountRequestDto accountRequestDto) {
//		Account dbaccount = accountRepo.save(mapper.map(accountRequestDto, Account.class));
//		return mapper.map(dbaccount, AccountResponseDto.class);
//	}
//
//	// delete an account
//	@Override
//	public void deleteAccount(Account account) {
//		accountRepo.delete(account);
//	}
//
//	// delete all accounts
//	@Override
//	public void deleteAllAccounts() {
//		accountRepo.deleteAll();
//	}
//}

package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.AccountRequestDto;
import com.aurionpro.bank.dto.AccountResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Account;
import com.aurionpro.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	private ModelMapper mapper;

	private AccountServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all accounts with pagination
	@Override
	public PageResponse<AccountResponseDto> getAllAccounts(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Account> accounts = accountRepo.findAll(pageable);

		List<Account> dbAccounts = accounts.getContent();
		List<AccountResponseDto> accountDtoList = new ArrayList<>();

		for (Account account : dbAccounts) {
			accountDtoList.add(mapper.map(account, AccountResponseDto.class));
		}

		return new PageResponse<>(accounts.getTotalPages(), accounts.getSize(), accounts.getTotalElements(),
				accounts.isLast(), accountDtoList);
	}

	// Add or update account
	@Override
	public AccountResponseDto addAccount(AccountRequestDto accountRequestDto) {
		Account dbAccount = accountRepo.save(mapper.map(accountRequestDto, Account.class));
		return mapper.map(dbAccount, AccountResponseDto.class);
	}

	// Delete an account
	@Override
	public void deleteAccount(Account account) {
		accountRepo.delete(account);
	}

	// Delete all accounts
	@Override
	public void deleteAllAccounts() {
		accountRepo.deleteAll();
	}
}
