package com.aurionpro.Day3HW;

import java.util.Scanner;

public class ShiftCharacters {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Taking input String from the user
		System.out.println("Enter the String: ");
		String inputString = scanner.nextLine();
		
		String shiftedString = "";
		
		System.out.println("Enter the shift value: ");
		int shiftValue = scanner.nextInt();
		
		int sizeOfString = inputString.length();
		
		char[] array = new char[sizeOfString];
		char[] shiftedArray = new char[sizeOfString];
		
		//Adding string characters to the char array
		for (int i = 0; i < array.length; i++) {
			array[i] = inputString.charAt(i);
		}
		
		int shiftedIndex = 0;
		
		for (int i = sizeOfString - shiftValue; i < sizeOfString; i++) {
			shiftedArray[shiftedIndex] = array[i];
			shiftedIndex++;
		}
		
		for (int i = 0; i < sizeOfString - shiftValue; i++) {
			shiftedArray[shiftedIndex] = array[i];
			shiftedIndex++;
		}
		
		for (int i = 0; i < shiftedArray.length; i++) {
			shiftedString = shiftedString + shiftedArray[i];
		}
		
		System.out.println("Shifted String is: "+shiftedString);
		
		scanner.close();
	}
}
