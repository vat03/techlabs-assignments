package com.aurionpro.TwoDArray;

import java.util.Scanner;

public class TwoDArray {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of rows of the matrix: ");
		int numberOfRows = scanner.nextInt();
		
		System.out.print("Enter number of columns of the matrix: ");
		int numberOfColumns = scanner.nextInt();
		
		int[][] matrix = new int[numberOfRows][numberOfColumns];
		
		System.out.println();
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				System.out.print("Enter element of row "+(i+1)+" & column "+(j+1)+": ");
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		System.out.println("\nMatrix is: ");
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		scanner.close();
	}
}
