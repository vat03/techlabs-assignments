package com.aurionpro.test;

import com.aurionpro.model.Circle;
import com.aurionpro.model.Rectangle;
import com.aurionpro.model.Shape;
import com.aurionpro.model.Triangle;

public class ShapeTest {
	public static void main(String[] args) {
		Shape circle = new Circle(12);
		circle.area();
		
		Shape rectangle = new Rectangle(5, 10);
		rectangle.area();
		
		Shape triangle = new Triangle(3, 6);
		triangle.area();
	}
}
