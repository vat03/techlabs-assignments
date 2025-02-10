package com.aurionpro.loops;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String[] args) {
		
		Scanner scannner = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int number = scannner.nextInt();
		int remainder = 0;
		int sum = 0;
		
		while(number > 0)
		{
			remainder = number % 10;
			sum = sum + remainder;
			number = number / 10;
		}
		
		System.out.println("Sum of digits of "+number+" is "+sum);
		
		scannner.close();
	}
}
