package com.aurionpro.test;

import com.aurionpro.model.Box;

public class BoxStaticTest {
	public static void main(String[] args) {
		
		//Box box1 = new Box();
		System.out.println(Box.getCount());
		//Box box2 = new Box();
		System.out.println(Box.getCount());
		//Box box3 = new Box();
		System.out.println(Box.getCount());
	}
	
	static
	{
		int i = 4, j = 3;
		System.out.println("This is static block performing operations:");
		System.out.println("sum of i + j is: "+(i+j));
	}
}
