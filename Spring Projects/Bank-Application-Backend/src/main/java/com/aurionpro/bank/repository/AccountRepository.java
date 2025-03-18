package com.aurionpro.bank.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bank.entity.Account;
import com.aurionpro.bank.entity.Customer;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	List<Account> findByCustomer(Customer customer);

	List<Account> findByCustomerAndIsActiveTrue(Customer customer);
	
	Page<Account> findByIsActive(boolean isActive, Pageable pageable);
}