package com.aurionpro.crudAccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.crudAccount.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
