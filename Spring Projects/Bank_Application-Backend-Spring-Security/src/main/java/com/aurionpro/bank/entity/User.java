package com.aurionpro.bank.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "user")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class User {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@Column(unique = true)
	private String email;

	@Column
	private String userType;

	@Column
	private boolean isActive = true;

	@Column
	private LocalDateTime userCreatedAt = LocalDateTime.now();

	public void deactivateUser() {
		this.isActive = false;
	}
}