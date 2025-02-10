package com.aurionpro.Day3HW;

import java.util.Scanner;

public class StudentMarksCalculator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Size of the array
		System.out.println("Enter number of subjects: ");
		int numberOfSubjects = scanner.nextInt();

		// array declaration
		double[] array = new double[numberOfSubjects];

		System.out.println();
		
		// array initialization
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter marks of subject " + (i + 1) + ": ");
			double input = scanner.nextDouble();
			if(input < 0)
			{
				System.out.println("\nPlease enter valid marks !!");
				System.out.print("Enter marks of subject " + (i + 1) + ": ");
				array[i] = scanner.nextDouble();
			}
			else
			{
				array[i] = input;
			}
		}

		// printing the array
		System.out.println("\nMarks are: ");
		for (double i : array) {
			System.out.print(i + " ");
		}
		
		double highestMarks = array[0];
		double lowestMarks = array[0];
		double averageMarks = 0;
		double sum = 0;
		
		for(int i = 0;i < array.length; i++)
		{
			if(array[i] > highestMarks)
			{
				highestMarks = array[i];
			}
			
			if(array[i] < lowestMarks)
			{
				lowestMarks = array[i];
			}
			
			sum = sum + array[i];
		}
		
		averageMarks = sum/numberOfSubjects;
	
		System.out.println("\n\nHighest marks are: "+highestMarks);
		System.out.println("Lowest marks are: "+lowestMarks);
		System.out.println("Average marks are: "+averageMarks);
		
		scanner.close();
	}
}
