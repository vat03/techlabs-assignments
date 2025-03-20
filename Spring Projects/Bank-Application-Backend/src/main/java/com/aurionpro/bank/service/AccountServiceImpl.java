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

import com.aurionpro.bank.dto.AccountRequestDto;
import com.aurionpro.bank.dto.AccountResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Account;
import com.aurionpro.bank.entity.Customer;
import com.aurionpro.bank.repository.AccountRepository;
import com.aurionpro.bank.repository.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private CustomerRepository customerRepo;

	private ModelMapper mapper;

	public AccountServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all active accounts with pagination
	@Override
	public PageResponse<AccountResponseDto> getAllAccounts(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Account> accountPage = accountRepo.findByIsActive(true, pageable);

		List<Account> dbAccounts = accountPage.getContent();
		List<AccountResponseDto> accountDtos = new ArrayList<>();

		for (Account account : dbAccounts) {
			accountDtos.add(mapper.map(account, AccountResponseDto.class));
		}

		PageResponse<AccountResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(accountDtos);
		pageResponse.setTotalPages(accountPage.getTotalPages());
		pageResponse.setPageSize(accountPage.getSize());
		pageResponse.setTotalElements(accountPage.getTotalElements());
		pageResponse.setLast(accountPage.isLast());

		return pageResponse;
	}

	// Add a new account and link it to a customer
	@Override
	public AccountResponseDto addAccount(AccountRequestDto accountRequestDto) {
		Optional<Customer> customerOptional = customerRepo.findById(accountRequestDto.getCustomerId());
		if (customerOptional.isEmpty()) {
			throw new RuntimeException("Customer not found with ID: " + accountRequestDto.getCustomerId());
		}

		Customer customer = customerOptional.get();

		Account account = new Account();
		account.setAccountNumber(accountRequestDto.getAccountNumber());
		account.setBalance(accountRequestDto.getBalance());
		account.setAccountType(accountRequestDto.getAccountType());
		account.setCustomer(customer);
		account.setActive(true);

		Account savedAccount = accountRepo.save(account);
		return mapper.map(savedAccount, AccountResponseDto.class);
	}

	// update account
	@Override
	public AccountResponseDto updateAccount(int accountId, AccountRequestDto accountRequestDto) {
		Optional<Account> optionalAccount = accountRepo.findById(accountId);
		if (optionalAccount.isEmpty()) {
			throw new RuntimeException("Account not found with ID: " + accountId);
		}

		Account account = optionalAccount.get();
		account.setBalance(accountRequestDto.getBalance());
		account.setAccountType(accountRequestDto.getAccountType());

		Account updatedAccount = accountRepo.save(account);
		return mapper.map(updatedAccount, AccountResponseDto.class);
	}
	
	// Soft delete an account
	@Override
	@Transactional
	public void deleteAccount(int accountId) {
		Optional<Account> accountOptional = accountRepo.findById(accountId);
		if (accountOptional.isPresent()) {
			Account account = accountOptional.get();
			account.setActive(false);
			accountRepo.save(account);
		} else {
			throw new RuntimeException("Account not found with ID: " + accountId);
		}
	}

//	@Override
//	@Transactional
//	public void deleteAllAccounts() {
//		List<Account> allAccounts = accountRepo.findAll();
//		if (allAccounts.isEmpty()) {
//			throw new RuntimeException("No accounts found to delete!");
//		}
//		for (Account account : allAccounts) {
//			account.setActive(false);
//		}
//		accountRepo.saveAll(allAccounts);
//	}
}
