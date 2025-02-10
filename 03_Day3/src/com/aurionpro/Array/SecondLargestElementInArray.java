package com.aurionpro.Array;

import java.util.Scanner;

public class SecondLargestElementInArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Size of the array
		System.out.print("Enter size of the array: ");
		int sizeOfArray = scanner.nextInt();

		System.out.println();

		// array declaration
		int[] array = new int[sizeOfArray];

		// array initialization
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
		}

		// printing the array
		System.out.println("\nArray elements are: ");
		for (int i : array) {
			System.out.print(i + " ");
		}

		// printing the output by calling the function
		System.out.println("\n\nSecond Largest element in this array is: "+ secondLargest(array));
		scanner.close();
	}

	// function to find second largest element of the array
	public static int secondLargest(int array[]) {
		int largestElement = array[0];
		int secondLargestElement = array[1];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > largestElement) {
				secondLargestElement = largestElement;
				largestElement = array[i];
			}

			if (array[i] < largestElement && array[i] > secondLargestElement) {
				secondLargestElement = array[i];
			}
		}

		return secondLargestElement;
	}
}
