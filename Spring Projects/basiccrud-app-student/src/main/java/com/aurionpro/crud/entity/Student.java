package com.aurionpro.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Column(name = "studentId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "rollNumber")
	private int rollNumber;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;

	public Student() {
	}

	public Student(int studentId, int rollNumber, String name, int age) {
		this.studentId = studentId;
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", rollNumber=" + rollNumber + ", name=" + name + ", age=" + age
				+ "]";
	}
}