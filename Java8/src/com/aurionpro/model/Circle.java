package com.aurionpro.model;

public class Circle implements Shape{

	public void area() {
		System.out.println("Area of circle");
	}

	// overridden method
//	public void show()
//	{
//		System.out.println("From circle show");
//	}
	
	
	// overridden method
	public void display()
	{
		System.out.println("From circle display");
	}
}
