package com.aurionpro.Day3HW;

import java.util.Scanner;

public class Substring {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Take user input of main string
		System.out.print("Enter a String: ");
		String inputString = scanner.nextLine().toLowerCase();

		// Take user input of sub string to be found
		System.out.print("\nEnter the substring to be checked: ");
		String subString = scanner.nextLine().toLowerCase();

		System.out.println("\nInput String: " + inputString);
		System.out.println("SubString to be searched: " + subString);

		System.out.println();

		System.out.println("Substring found: "+ isSubstring(inputString, subString));

		scanner.close();
	}

	public static boolean isSubstring(String inputString, String subString) {
		int stringLength = inputString.length();
		int subStringLength = subString.length();

		if (stringLength < subStringLength) {
			return false;
		} else {
			for (int i = 0; i <= stringLength - subStringLength; i++) {
				int j;
				for (j = 0; j < subStringLength; j++) {
					if (inputString.charAt(i + j) != subString.charAt(j)) {
						break;
					}
				}
				if (j == subStringLength) {
					return true;
				}
			}
		}
		return false;
	}
}
