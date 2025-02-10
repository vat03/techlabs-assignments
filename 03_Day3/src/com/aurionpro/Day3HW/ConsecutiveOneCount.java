package com.aurionpro.Day3HW;

import java.util.Scanner;

public class ConsecutiveOneCount {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Size of the array
		System.out.println("Enter size of the array: ");
		int sizeOfArray = scanner.nextInt();

		// array declaration
		int[] array = new int[sizeOfArray];

		// array initialization
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			int input = scanner.nextInt();
			if(input == 0 || input == 1)
			{
				array[i] = input;
			}
			else
			{
				System.out.println("Enter 0 or 1 or else by default 0!!");
			}
		}

		// printing the array
		System.out.println("\nArray elements are: ");
		for (int i : array) {
			System.out.print(i + " ");
		}

		int tempCount = 0;
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				tempCount++;
				count = max(tempCount, count);
			} else {
				tempCount = 0;
			}
		}

		if(count <= 1)
		{
			System.out.println("\n\nThere are no consecutive one's in the array.");
		}
		else
		{
			System.out.println("\n\nThere are " + count + " consecutive one's in the array.");
		}
		
		scanner.close();
	}
	
	//Method to find maximum value of count
	public static int max(int count, int tempCount)
	{
		int maxValue;
		if(count > tempCount)
		{
			maxValue = count;
		}
		else
		{
			maxValue = tempCount;
		}
		
		return maxValue;
	}
}
