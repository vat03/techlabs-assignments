package com.aurionpro.entity;

public class Student {
	private int studentId;
	private int rollNumber;
	private String name;
	private int age;

	public Student() {

	}

	public Student(int studentID, int rollNumber, String name, int age) {
		this.studentId = studentID;
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

	public void setStudentId(int studentID) {
		this.studentId = studentID;
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
