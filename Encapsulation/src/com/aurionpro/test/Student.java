package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.StudentDetails;

public class Student {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
//		Using constructor
		StudentDetails student1 = new StudentDetails();
		StudentDetails student2 = new StudentDetails("Vatsal", 100, 55.5);
		StudentDetails student3 = new StudentDetails(student2);
		
// 		Using getter setter methods
//		System.out.println("Enter Student name: ");
//		student1.setName(scanner.nextLine());
//		
//		System.out.println("Enter student roll number: ");
//		student1.setRollNumber(scanner.nextInt()) ;
//		
//		System.out.println("Enter student marks: ");
//		student1.setMarks(scanner.nextDouble());
		
		System.out.println();
		
		//default constructor
		student1.displayDetails();
		
		System.out.println();
		
		//parameterized constructor
		student2.displayDetails();
		
		System.out.println();

		//Copy constructor
		student3.displayDetails();
		
		scanner.close();
	}
}


