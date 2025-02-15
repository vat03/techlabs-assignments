package com.aurionpro.test;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Function<Integer, Integer> getSquare = (number) -> number * number;
		
		System.out.println("Enter a number: ");
		int number = scanner.nextInt();
		
		System.out.println("Square of "+number+" is "+getSquare.apply(number));
		
		scanner.close();
	}
}
