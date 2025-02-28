package com.aurionpro.entity;

public class Student {
	private int rollNumber;
	private String name;
	private int age;
	
	public Student()
	{
		
	}
	
	public Student(int rollNumber, String name, int age) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
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

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
