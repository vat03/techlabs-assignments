package com.aurionpro.crud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "students")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	@Column(name = "studentId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "rollNumber")
	private int rollNumber;
	@Column(name = "name")
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@Column(name = "age")
	@Min(value = 18, message = "Age should be above 18")
	@NotNull(message = "Age cannot be blank")
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressID")
	private Address address;
}