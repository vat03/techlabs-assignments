package com.aurionpro.loops;

public class EvenNumbersUsingWhileLoop {
	public static void main(String[] args) {
		System.out.println("Even numbers from 1 to 100 using While loop");
		int i = 1;
		while(i <= 100)
		{
			if(i%2 == 0)
			{
				System.out.println(i);
			}
			i++;
		}
	}
}
