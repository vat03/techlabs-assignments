package com.aurionpro.Array;

import java.util.Scanner;

public class SortedSquareOfElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Size of the array
		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();
		
		System.out.println();
		
		int[] array = new int[size];
		
		//Input to the array
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter number "+(i+1)+": ");
			array[i] = scanner.nextInt();
		}
		
		System.out.println();
		
		// Sorting the input
		array = sort(array);
		
		//printing the input array
		System.out.println("Input Array is: ");
		for (int i : array) {
			System.out.print(i+" ");
		}
		
		System.out.println("\n");
		
		//Squaring the elements of the array
		square(array);
		
		//Sorting the output array
		array = sort(array);
		
		//printing the output array
		System.out.println("Output array is: ");
		for (int i : array) {
			System.out.print(i+" ");
		}
		
		scanner.close();
	}
	
	// Sorting method
	public static int[] sort(int array[])
	{
		int[] sortedArray = new int[array.length];
		int left = 0, right = array.length - 1, index = array.length - 1;
		
		while(left <= right)
		{
			if(array[left] > array[right])
			{
				sortedArray[index] = array[left];
				left++;
			}
			else
			{
				sortedArray[index] = array[right];
				right--;
			}
			index--;
		}
		return sortedArray;
	}
	
	// Squaring method
	public static int[] square(int[] array)
	{
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * array[i];
		}
		return array;
	}
}
