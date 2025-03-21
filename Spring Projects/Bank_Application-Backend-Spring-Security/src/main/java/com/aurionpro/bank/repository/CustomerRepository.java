package com.aurionpro.bank.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByUserUserId(int userId);

	Page<Customer> findByIsActive(boolean isActive, Pageable pageable);
}