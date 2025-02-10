package com.aurionpro.conditionalstatements;

import java.util.Scanner;

public class SwapNumberWithoutThirdVar {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number 1: ");
		int number1 = scanner.nextInt();
		System.out.println("Enter number 2: ");
		int number2 = scanner.nextInt();

		number1 = number1 + number2;
		number2 = number1 - number2;
		number1 = number1 - number2;

		System.out.println("Numbers after swapping are: ");
		System.out.println("Number 1: " + number1);
		System.out.println("Number 2: " + number2);

		scanner.close();
	}
}
