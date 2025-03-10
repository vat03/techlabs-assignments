package com.aurionpro.model;

public class StudentDetails
{
	private String name;
	private int rollNumber;
	private double marks;
	
	//Default constructor
	public StudentDetails()
	{
		System.out.println("Default constructor");
	}
	
	//parameterized Constructor
	public StudentDetails(String name)
	{
		this.name = name;
	}
	
	public StudentDetails(double marks) {
		this.marks = marks;
	}
	
	public StudentDetails(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public StudentDetails(String name, int rollNumber) {
		
		this.name = name;
		this.rollNumber = rollNumber;
	}
	
	public StudentDetails(int rollNumber, double marks) 
	{	
		this.rollNumber = rollNumber;
		this.marks = marks;
	}
	
	public StudentDetails(String name, double marks) {
		
		this.name = name;
		this.marks = marks;
	}

	public StudentDetails(String name, int rollNumber, double marks) {
	
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}

	
	// Copy constructor
	public StudentDetails(StudentDetails other)
	{
		this.name = other.name;
		this.rollNumber = other.rollNumber;
		this.marks = other.marks;
	}
	
	// Getter setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public void displayDetails()
	{
		System.out.println("Student details: ");
		System.out.println("Student name: "+name);
		System.out.println("Student roll number: "+rollNumber);
		System.out.println("Student marks: "+marks);
	}
}
