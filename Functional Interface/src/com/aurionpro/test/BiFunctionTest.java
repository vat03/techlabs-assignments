package com.aurionpro.test;

import java.util.Scanner;
import java.util.function.BiFunction;

public class BiFunctionTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BiFunction<Integer, Integer, Integer> multiply = (number1, number2) -> number1 * number2;
		
		System.out.print("Enter number 1: ");
		int number1 = scanner.nextInt();
		System.out.println();
		System.out.print("Enter number 2: ");
		int number2 = scanner.nextInt();
		
		System.out.println("\nMultiplication of "+number1+" and "+number2+" is "+multiply.apply(number1, number2));
	
		scanner.close();
	}
}
