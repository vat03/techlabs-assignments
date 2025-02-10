package com.aurionpro.Array;

public class ArrayDeclaration {
	public static void main(String[] args) {
		int[] array1;
		//int array2[];   <--- NOT RECOMMENDED WAY 
		
		array1 = new int[5];
		
		for(int i = 0; i < array1.length; i++)
		{
			array1[i] = i+1;
		}
		
		for (int num : array1) {
			System.out.println(num);
		}
	}
}
