package com.aurionpro.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
