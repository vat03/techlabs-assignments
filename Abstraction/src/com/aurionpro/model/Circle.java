package com.aurionpro.model;

public class Circle implements Shape{

	double radius;
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	@Override
	public void area() {
		System.out.println("Area of Circle is: "+(3.14*radius*radius));
	}

}
