package com.aurionpro.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Customer {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private boolean isActive = true;
	
	@OneToOne
	@JoinColumn(name = "userId", unique = true)
	private User user;

	public void deactivateCustomer() {
		this.user.deactivateUser();
	}
}
