package com.aurionpro.model;

import com.aurionpro.exception.AgeNotValid;

public class Voter {
	private String name;
	private String voterId;
	private int age;
	
	// Parameterized Constructor
	public Voter(String name, String voterId, int age) {
		this.name = name;
		this.voterId = voterId;
		if(age < 18)
		{
			throw new AgeNotValid(age);
		}
		this.age = age;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getVoterId() {
		return voterId;
	}

	public int getAge() {
		return age;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public void setAge(int age) {
		if(age < 18)
		{
			throw new AgeNotValid(age);
		}
		this.age = age;
	}

	public String toString() {
		return "Voter Name=" + name + ", Voter Id=" + voterId + ", Voter Age=" + age;
	}
}
