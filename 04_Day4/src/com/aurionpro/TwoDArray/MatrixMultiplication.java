package com.aurionpro.TwoDArray;

import java.util.Scanner;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Matrix 1: ");
		System.out.print("Enter number of rows of the matrix 1: ");
		int numberOfRows1 = scanner.nextInt();

		System.out.print("Enter number of columns of the matrix 1: ");
		int numberOfColumns1 = scanner.nextInt();
		
		System.out.println();
		
		System.out.println("Matrix 2: ");
		System.out.print("Enter number of rows of the matrix 2: ");
		int numberOfRows2 = scanner.nextInt();

		System.out.print("Enter number of columns of the matrix 2: ");
		int numberOfColumns2 = scanner.nextInt();

		int[][] matrix1 = new int[numberOfRows1][numberOfColumns1];
		int[][] matrix2 = new int[numberOfRows2][numberOfColumns2];

		System.out.println();

		//Matrix 1 initialization
		System.out.println("Enter values for matrix 1: ");
		for (int i = 0; i < numberOfRows1; i++) {
			for (int j = 0; j < numberOfColumns1; j++) {
				System.out.print("Enter element of row " + (i + 1)
						+ " & column " + (j + 1) + ": ");
				matrix1[i][j] = scanner.nextInt();
			}
		}

		//Matrix 2 initialization
		System.out.println("\nEnter values for matrix 2: ");
		for (int i = 0; i < numberOfRows2; i++) {
			for (int j = 0; j < numberOfColumns2; j++) {
				System.out.print("Enter element of row " + (i + 1)
						+ " & column " + (j + 1) + ": ");
				matrix2[i][j] = scanner.nextInt();
			}
		}
		
		//Matrix 1 printing
		System.out.println("\nMatrix 1 is: ");
		for (int i = 0; i < numberOfRows1; i++) {
			for (int j = 0; j < numberOfColumns1; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("");
		
		//Matrix 2 printing
		System.out.println("\nMatrix 2 is: ");
		for (int i = 0; i < numberOfRows2; i++) {
			for (int j = 0; j < numberOfColumns2; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}
		
		// Matrix multiplication Calculation
		if(numberOfRows2 != numberOfColumns1)
		{
			System.out.println("\nMatrix multiplication not possible !!");
		}
		else
		{
			int[][] multiplicationMatrix = new int[numberOfRows1][numberOfColumns2];
			for (int i = 0; i < numberOfRows1; i++) {
				for (int j = 0; j < numberOfColumns2; j++) {
					for (int k = 0; k < numberOfRows2; k++) {
						multiplicationMatrix[i][j] = multiplicationMatrix[i][j] + matrix1[i][k] * matrix2[k][j];
					}
				}
			}
		
			System.out.println("\nMultiplication Matrix is: ");
			for (int i = 0; i < multiplicationMatrix.length; i++) {
				for (int j = 0; j < multiplicationMatrix[i].length; j++) {
					System.out.print(multiplicationMatrix[i][j]+" ");
				}
				System.out.println();
			}
		
		}
		scanner.close();
	}
}
