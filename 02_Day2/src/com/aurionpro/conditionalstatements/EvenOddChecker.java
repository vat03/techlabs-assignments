package com.aurionpro.conditionalstatements;

import java.util.Scanner;

public class EvenOddChecker {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int number = scanner.nextInt();
		
		if(number%2 == 0)
		{
			System.out.println(number+" is an Even number.");
		}
		else
		{
			System.out.println(number+" is an odd number.");
		}
		
		scanner.close();
	}
}
