package com.aurionpro.conditionalstatements;

import java.util.Scanner;

public class CheckPositiveNegative {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a number: ");
	int number = scanner.nextInt();
	
	if(number > 0)
	{
		System.out.println(number+" is positive.");
	}
	else if(number < 0)
	{
		System.out.println(number+" is negative.");
	}
	else
	{
		System.out.println(number+" is neither positive nor negative.");
	}
	
	scanner.close();
}
}
