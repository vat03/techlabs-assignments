package com.aurionpro.loops;

import java.util.Scanner;

public class PallindromeCheck {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = scanner.nextInt();
		
		int originalNumner = number;
		int reverseNumber = 0;
		int remainder = 0;
		
		while(number > 0)
		{
			remainder = number % 10;
			reverseNumber = reverseNumber * 10 + remainder;
			number = number / 10;
		}
		
		if(reverseNumber == originalNumner)
		{
			System.out.println(originalNumner+" is a Palindrome number.");
		}
		else
		{
			System.out.println(originalNumner+" is not a Palindrome number.");
		}
		scanner.close();
	}
}
