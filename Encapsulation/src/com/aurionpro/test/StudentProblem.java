package com.aurionpro.test;

import com.aurionpro.model.StudentProblemDetails;

public class StudentProblem {
	public static void main(String[] args) {
		StudentProblemDetails student1 = new StudentProblemDetails(001, "user 1", 80, 70, 60);
		StudentProblemDetails student2 = new StudentProblemDetails(002, "user 2", 90, 90, 85);
		StudentProblemDetails student3 = new StudentProblemDetails(003, "user 3", 33, 22, 39);
		
		System.out.println("Student 1 details: ");
		System.out.println("Student id: "+student1.getStudentId());
		System.out.println("Student name: "+student1.getName());
		System.out.println("Math marks: "+student1.getMathMarks());
		System.out.println("Science marks: "+student1.getScienceMarks());
		System.out.println("English marks: "+student1.getEnglishMarks());
		System.out.println("Total marks: "+student1.calculateTotalMarks());
		System.out.println("Percentage: "+student1.calculatePercentage());
		System.out.println("Grade: "+student1.getGrade());
		
		System.out.println();
		
		System.out.println("Student 2 details: ");
		System.out.println("Student id: "+student2.getStudentId());
		System.out.println("Student name: "+student2.getName());
		System.out.println("Math marks: "+student2.getMathMarks());
		System.out.println("Science marks: "+student2.getScienceMarks());
		System.out.println("English marks: "+student2.getEnglishMarks());
		System.out.println("Total marks: "+student2.calculateTotalMarks());
		System.out.println("Percentage: "+student2.calculatePercentage());
		System.out.println("Grade: "+student2.getGrade());
		
		System.out.println();
		
		System.out.println("Student 3 details: ");
		System.out.println("Student id: "+student3.getStudentId());
		System.out.println("Student name: "+student3.getName());
		System.out.println("Math marks: "+student3.getMathMarks());
		System.out.println("Science marks: "+student3.getScienceMarks());
		System.out.println("English marks: "+student3.getEnglishMarks());
		System.out.println("Total marks: "+student3.calculateTotalMarks());
		System.out.println("Percentage: "+student3.calculatePercentage());
		System.out.println("Grade: "+student3.getGrade());
		
		System.out.println("Updated marks: ");
		student3.setEnglishMarks(100);
		System.out.println("Updated English marks: "+student3.getEnglishMarks());
	}
}