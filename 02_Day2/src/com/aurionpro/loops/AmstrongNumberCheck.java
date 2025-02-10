package com.aurionpro.loops;

import java.util.Scanner;

public class AmstrongNumberCheck {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = scanner.nextInt();

		int originalNumber = number;
		int remainder = 0;
		int sum = 0;
		int cube = 0;
		
		while(number > 0)
		{
			remainder = number % 10;
			cube = (int)Math.pow(remainder, 3);
			sum = sum + cube;
			number = number / 10;
		}
		
		if(sum == originalNumber)
		{
			System.out.println(originalNumber+" is an Amstrong Number.");
		}
		else
		{
			System.out.println(originalNumber+" is not an Amstrong Number.");
		}
		scanner.close();
	}
}
