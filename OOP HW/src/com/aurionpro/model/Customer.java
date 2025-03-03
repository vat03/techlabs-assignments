package com.aurionpro.model;

import java.time.LocalDate;

public class Customer {
	private static int customerId = 0;
	private String name;
	private String email;
	private LocalDate dateOfBirth;
	private String phoneNumber;

	// Default Constructor
	public Customer() {
	}

	// Parameterized Constructor
	public Customer(String name, String email, LocalDate dateOfBirth, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}

	// Getter methods
	public static int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Setter methods
	public static void setCustomerId(int customerId) {
		Customer.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
