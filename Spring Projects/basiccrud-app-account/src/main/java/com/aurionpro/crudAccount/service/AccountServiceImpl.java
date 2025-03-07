package com.aurionpro.crudAccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crudAccount.Entity.Account;
import com.aurionpro.crudAccount.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepo.findAll();
		return accounts;
	}
}
