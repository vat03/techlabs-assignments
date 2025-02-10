package com.aurionpro;

import java.util.Scanner;

public class Information {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter your age: ");
		int age = scanner.nextInt();
		
		System.out.println("Enter your CGPA: ");
		float cgpa = scanner.nextFloat();
		
		System.out.println("Do you like JAVA: ");
		boolean opinion = scanner.nextBoolean();
		
		scanner.close();
	
		output(name, age, cgpa, opinion);
	}
	
	static void output(String name, int age, float cgpa, boolean opinion)
	{
		System.out.println("Hey "+ name+" !!");
		System.out.println("You are "+age+" years old.");
		System.out.println("Your CGPA is "+cgpa);
		System.out.println("You like JAVA - "+opinion+".");
	}
}
