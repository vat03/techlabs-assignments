package com.aurionpro.Day2HW;

import java.util.Scanner;

public class CurrencyDenominationWithdrawalApp {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Variables to store the count of notes
		int countOf2000 = 0;
		int countOf500 = 0;
		int countOf200 = 0;
		int countOf100 = 0;

		System.out.print("Enter withdrawal amount: ");
		int withdrawalAmount = scanner.nextInt();

		System.out.println();
		
		// To check if withdrawal amount is positive
		if (withdrawalAmount >= 0) 
		{
			// To check if withdrawal amount is not greater than 50000
			if (withdrawalAmount <= 50000) 
			{
				// To check if withdrawal amount is a multiple of 100
				if (withdrawalAmount % 100 == 0) 
				{
					int remainingAmount = withdrawalAmount;
					while (remainingAmount > 0) 
					{
						if (remainingAmount >= 2000) 
						{
							countOf2000 = remainingAmount / 2000;
							remainingAmount = remainingAmount - countOf2000 * 2000;
						} 
						else if (remainingAmount >= 500) 
						{
							countOf500 = remainingAmount / 500;
							remainingAmount = remainingAmount - countOf500 * 500;
						}
						else if (remainingAmount >= 200) 
						{
							countOf200 = remainingAmount / 200;
							remainingAmount = remainingAmount - countOf200 * 200;
						} 
						else if (remainingAmount >= 100) 
						{
							countOf100 = remainingAmount / 100;
							remainingAmount = remainingAmount - countOf100 * 100;
						}
					}

					//printing the count of notes summing up to the withdrawal amount
					if (countOf2000 > 0) 
					{
						System.out.println("Count of 2000 denomination currency: "+ countOf2000);
					}
					if (countOf500 > 0)
					{
						System.out.println("Count of 500 denomination currency: "+ countOf500);
					}
					if (countOf200 > 0) 
					{
						System.out.println("Count of 200 denomination currency: "+ countOf200);
					}
					if (countOf100 > 0) 
					{
						System.out.println("Count of 100 denomination currency: "+ countOf100);
					}
				} 
				else 
				{
					System.out.println("Please enter a valid withdrawal amount !!\nAmount should be multiple of 100.");
				}
			} 
			else 
			{
				System.out.println("Please enter a valid withdrawal amount !!\nAmount exceeds withdrawal limit of 50000.");
			}
		} 
		else 
		{
			System.out.println("Please enter a valid withdrawal amount !!\nAmount cannot be negative.");
		}
		
		scanner.close();
	}
}
