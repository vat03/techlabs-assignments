package com.aurionpro.model;

public class Triangle implements Shape{
	double height, base;
	
	public Triangle(double height, double base) {
		this.height = height;
		this.base = base;
	}

	@Override
	public void area() {
		System.out.println("Area of Triangle is: "+(0.5 * base * height));
	}

}
