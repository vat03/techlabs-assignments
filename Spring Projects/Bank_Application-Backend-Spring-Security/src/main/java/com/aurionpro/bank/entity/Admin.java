package com.aurionpro.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Admin {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private boolean isActive = true;

	@OneToOne
	@JoinColumn(name = "userId", unique = true)
	private User user;

	public void deactivateAdmin() {
		this.user.deactivateUser();
	}
}
