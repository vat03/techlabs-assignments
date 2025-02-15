package com.aurionpro.test;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class BiPredicateTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		BiPredicate<Integer, Integer> areEqual = (number1, number2) -> {
			if (number1 == number2)
				return true;
			return false;
		};

		System.out.print("Enter number 1: ");
		int number1 = scanner.nextInt();
		System.out.println();
		System.out.print("Enter number 2: ");
		int number2 = scanner.nextInt();

		System.out.println("\n" + number1 + " and " + number2 + " are equal: " + areEqual.test(number1, number2));

		scanner.close();
	}
}
