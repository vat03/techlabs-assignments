package com.aurionpro.Array;

import java.util.Scanner;

public class PeakValueOfArray {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Size of the array
		System.out.println("Enter size of the array: ");
		int sizeOfArray = scanner.nextInt();
		
		//array declaration
		int[] array = new int[sizeOfArray];
		int[] peakElementsArray = new int[sizeOfArray];
		
		//array initialization
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element "+(i+1)+": ");
			array[i] = scanner.nextInt();
		}
		
		//printing the array
		System.out.println("\nArray elements are: ");
		for (int i : array) {
			System.out.print(i+" ");
		}
		
		int numberOfPeaks = 0;
		int index = 0;
		
		//for start
		if(array[0] > array[1])
		{
			numberOfPeaks++;
			peakElementsArray[index] = array[0];
			index++;
		}
		
		//for end
		if(array[(array.length - 1)] > array[(array.length-1)-1])
		{
			numberOfPeaks++;
			peakElementsArray[index] = array[array.length - 1];
			index++;
		}
		
		//for middle elements
		for (int i = 1; i < array.length - 1; i++) {
			if(array[i] > array[i-1] && array[i] > array[i+1]) 
			{
				numberOfPeaks++;
				peakElementsArray[index] = array[i];
				index++;
			}
		}
		
		System.out.println("\n\nTotal number of peak values are: "+numberOfPeaks);
		
		System.out.println("\nPeak Elements are: ");
		for (int i = 0; i < numberOfPeaks; i++) {
			System.out.print(peakElementsArray[i]+" ");
		}
		
		scanner.close();
	}
}
