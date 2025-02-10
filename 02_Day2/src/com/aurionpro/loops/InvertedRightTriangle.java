package com.aurionpro.loops;

import java.util.Scanner;

public class InvertedRightTriangle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Enter number of rows: ");
		int numberOfRows = scanner.nextInt();
		
		for(int i = numberOfRows; i > 0; i--)
		{
			for(int j = 1; j <= i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		scanner.close();
	}
}
