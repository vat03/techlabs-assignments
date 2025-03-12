package com.aurionpro.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "address")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Address {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int pincode;
}
