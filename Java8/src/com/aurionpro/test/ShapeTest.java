package com.aurionpro.test;

import com.aurionpro.model.Circle;
import com.aurionpro.model.Shape;

public class ShapeTest {
	public static void main(String[] args) {
		Shape shape = new Circle();
		Circle circle = new Circle();
		
		shape.area();
		
		Shape.display();
		circle.display();
		
		shape.show();
	}
}
