package com.aurionpro.crudAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crudAccount.Entity.Account;
import com.aurionpro.crudAccount.service.AccountService;

@RestController
@RequestMapping("/accountapp")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
}
