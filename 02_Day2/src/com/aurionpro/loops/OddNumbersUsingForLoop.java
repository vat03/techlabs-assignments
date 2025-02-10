package com.aurionpro.loops;

public class OddNumbersUsingForLoop {
	public static void main(String[] args) {
		System.out.println("Odd Numbers from 1 to 100 using For loop");
		for(int i = 1; i <= 100; i++)
		{
			if(i%2 != 0)
			{
				System.out.println(i);
			}
		}
	}
}
