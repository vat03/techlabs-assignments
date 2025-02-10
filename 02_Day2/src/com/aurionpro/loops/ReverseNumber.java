package com.aurionpro.loops;
import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner scannner = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int number = scannner.nextInt();
		int reversedNumber = 0;
		int remainder = 0;
		
		while(number > 0)
		{
			remainder = number % 10;
			reversedNumber = reversedNumber * 10 + remainder;
			number = number / 10;
		}
		System.out.println(reversedNumber);
		scannner.close();
	}
}
