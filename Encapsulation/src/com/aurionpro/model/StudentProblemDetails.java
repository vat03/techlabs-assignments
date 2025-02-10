package com.aurionpro.model;

public class StudentProblemDetails {
	private int studentId;
	private String name;
	private int mathMarks;
	private int scienceMarks;
	private int englishMarks;
	
	public StudentProblemDetails()
	{
		System.out.println("Defalut Constructor");
	}
	
	public StudentProblemDetails(int studentId, String name, int mathMarks, int scienceMarks, int englishMarks)
	{
		this.studentId = studentId;
		this.name = name;
		this.mathMarks = mathMarks;
		this.scienceMarks = scienceMarks;
		this.englishMarks = englishMarks;
	}

	//Getter setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMathMarks() {
		return mathMarks;
	}

	public void setMathMarks(int mathMarks) {
		this.mathMarks = mathMarks;
	}

	public int getScienceMarks() {
		return scienceMarks;
	}

	public void setScienceMarks(int scienceMarks) {
		this.scienceMarks = scienceMarks;
	}

	public int getEnglishMarks() {
		return englishMarks;
	}

	public void setEnglishMarks(int englishMarks) {
		this.englishMarks = englishMarks;
	}

	//only getter for studentId
	public int getStudentId() {
		return studentId;
	}
	
	int totalMarks = 0;
	public int calculateTotalMarks()
	{
		totalMarks = mathMarks + scienceMarks + englishMarks;
		
		return totalMarks;
	}
	
	double percentage = 0;
	public double calculatePercentage()
	{
		percentage = ((double)totalMarks / 300) * 100;
	
		return percentage;
	}
	
	char grade;
	public char getGrade()
	{
		if(percentage >= 80 && percentage <= 100)
		{
			grade = 'A';
		}
		else if(percentage >= 60 && percentage < 80)
		{
			grade = 'B';
		}
		else if(percentage >= 35 && percentage < 60)
		{
			grade = 'C';
		}
		else
		{
			grade = 'F';
		}
		
		return grade;
	}
}
