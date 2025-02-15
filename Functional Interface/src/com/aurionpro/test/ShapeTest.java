package com.aurionpro.test;

import com.aurionpro.model.Shape;

public class ShapeTest {
	public static void main(String[] args) {
		Shape circle = () -> {
			double radius = 5;
			System.out.println("Area of Circle is: "+(3.14*radius*radius));
		};
		
		displayArea(circle);
	}
	
	public static void displayArea(Shape shape)
	{
		shape.area();
	}
}
