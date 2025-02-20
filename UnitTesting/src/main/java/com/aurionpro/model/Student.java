package com.aurionpro.model;

public class Student {
	StudentMarksService studentService;

	public Student(StudentMarksService studentService) {
		this.studentService = studentService;
	}

	public double getAverageMarks()
	{
		return (studentService.TotalMarks() / studentService.TotalNumberOfSubjects());
	}
}
