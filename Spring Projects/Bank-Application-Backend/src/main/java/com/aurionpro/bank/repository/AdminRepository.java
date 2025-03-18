package com.aurionpro.bank.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bank.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByUserUserId(int userId);

	Page<Admin> findByIsActive(boolean isActive, Pageable pageable);
}
