package com.aurionpro.Day3HW;

import java.util.Scanner;

public class NumberRepetationCount {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		//Size of the array
		System.out.println("Enter size of the array: ");
		int sizeOfArray = scanner.nextInt();
		
		//array declaration
		int[] array = new int[sizeOfArray];
		
		boolean[] visited = new boolean[sizeOfArray];
		
		//array initialization
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element "+(i+1)+": ");
			array[i] = scanner.nextInt();
			visited[i] = false;
		}
		
		//printing the array
		System.out.println("\nArray elements are: ");
		for (int i : array) {
			System.out.print(i+" ");
		}
		
		System.out.println("\n");
		boolean repetitionOccurs = false;
		
		for (int i = 0; i < array.length; i++) {
			if(visited[i])
			{
				continue;
			}
			
			int count = 1;
			for (int j = i + 1; j < array.length; j++) 
			{
				if(array[i] == array[j])
				{
					count++;
					visited[j] = true;
				}
			}
			
			if(count > 1)
			{
				System.out.println(array[i]+" -> "+count+" times");
				repetitionOccurs = true;
			}
		}
		
		if(repetitionOccurs == false)
		{
			System.out.println("All unique elements!! No repetation occurs in the array.");
		}
		
		scanner.close();
	}
}
