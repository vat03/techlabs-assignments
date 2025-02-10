package com.aurionpro.TwoDArray;

import java.util.Scanner;

public class MatrixOperation {
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
		int[][] addSubMatrix = new int[numberOfRows1][numberOfColumns1];

		System.out.println();

		//Matrix 1
		System.out.println("Enter values for matrix 1: ");
		for (int i = 0; i < numberOfRows1; i++) {
			for (int j = 0; j < numberOfColumns1; j++) {
				System.out.print("Enter element of row " + (i + 1)
						+ " & column " + (j + 1) + ": ");
				matrix1[i][j] = scanner.nextInt();
			}
		}

		System.out.println("\nEnter values for matrix 2: ");
		//Matrix 2
		for (int i = 0; i < numberOfRows2; i++) {
			for (int j = 0; j < numberOfColumns2; j++) {
				System.out.print("Enter element of row " + (i + 1)
						+ " & column " + (j + 1) + ": ");
				matrix2[i][j] = scanner.nextInt();
			}
		}
		
		//Matrix 1
		System.out.println("\nMatrix 1 is: ");
		for (int i = 0; i < numberOfRows1; i++) {
			for (int j = 0; j < numberOfColumns1; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("");
		
		//Matrix 2
		System.out.println("\nMatrix 2 is: ");
		for (int i = 0; i < numberOfRows2; i++) {
			for (int j = 0; j < numberOfColumns2; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nList of Operations: \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Transpose");
		System.out.print("Enter operation you want to perform: ");
		scanner.nextLine();
		String operation = scanner.nextLine();
		
		if(operation.equalsIgnoreCase("Addition"))
		{
			if(numberOfRows1 == numberOfRows2 && numberOfColumns1 == numberOfColumns2)
			{
				for (int i = 0; i < addSubMatrix.length; i++) {
					for (int j = 0; j < addSubMatrix[i].length; j++) {
						addSubMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
					}
				}
				
				System.out.println("\nAddition Matrix is: ");
				for (int i = 0; i < addSubMatrix.length; i++) {
					for (int j = 0; j < addSubMatrix[i].length; j++) {
						System.out.print(addSubMatrix[i][j]+" ");
					}
					System.out.println();
				}
			}
			else
			{
				System.out.println("\nMatrix size is different so Addition not possible !!");
			}
		}
		else if(operation.equalsIgnoreCase("Subtraction"))
		{
			if(numberOfRows1 == numberOfRows2 && numberOfColumns1 == numberOfColumns2)
			{
				for (int i = 0; i < addSubMatrix.length; i++) {
					for (int j = 0; j < addSubMatrix[i].length; j++) {
						addSubMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
					}
				}
				
				System.out.println("\nSubtraction Matrix is: ");
				for (int i = 0; i < addSubMatrix.length; i++) {
					for (int j = 0; j < addSubMatrix[i].length; j++) {
						System.out.print(addSubMatrix[i][j]+" ");
					}
					System.out.println();
				}
			}
			else
			{
				System.out.println("\nMatrix size is different so Subtraction not possible !!");
			}
		}
		else if(operation.equalsIgnoreCase("Multiplication"))
		{
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
		}
		else if(operation.equalsIgnoreCase("Transpose"))
		{
			int[][] transposeMatrix1 = new int[numberOfColumns1][numberOfRows1];
			int[][] transposeMatrix2 = new int[numberOfColumns2][numberOfRows2];
			
			//for matrix 1
			for(int i = 0; i < transposeMatrix1.length; i++)
			{
				for (int j = 0; j < transposeMatrix1[i].length; j++) {
					transposeMatrix1[i][j] = matrix1[j][i];
				}
			}
			
			//for matrix 2
			for(int i = 0; i < transposeMatrix2.length; i++)
			{
				for (int j = 0; j < transposeMatrix2[i].length; j++) {
					transposeMatrix2[i][j] = matrix2[j][i];
				}
			}
			
			//printing of transpose matrix
			//matrix 1
			System.out.println("Transpose matrix 1 is: ");
			for (int i = 0; i < transposeMatrix1.length; i++) {
				for (int j = 0; j < transposeMatrix1[i].length; j++) {
					System.out.print(transposeMatrix1[i][j]+" ");
				}
				System.out.println();
			}
			
			//matrix 2
			System.out.println("Transpose matrix 2 is: ");
			for (int i = 0; i < transposeMatrix2.length; i++) {
				for (int j = 0; j < transposeMatrix2[i].length; j++) {
					System.out.print(transposeMatrix2[i][j]+" ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("\nEnter a valid operation !!");
		}
		
		scanner.close();
	}
}
