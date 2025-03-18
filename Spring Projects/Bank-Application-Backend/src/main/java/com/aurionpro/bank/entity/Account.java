package com.aurionpro.bank.entity;

import java.time.LocalDateTime;

import com.aurionpro.bank.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "account")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Account {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	@Column(unique = true)
	private String accountNumber;

	@Column
	private double balance;

	@Enumerated(EnumType.STRING)
	@Column
	private AccountType accountType;

	@Column
	private boolean isActive = true;

	@Column
	private LocalDateTime accountCreatedAt = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	

	public void deactivateAccount() {
		this.isActive = false;
	}
}