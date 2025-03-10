package com.aurionpro.model;

public class Box {
	private double width;
	private double depth;
	private double height;
	public static int count;

	public Box() {
		count++;
	}

	public Box(double width, double height) {
		this();
		this.width = width;
		this.height = height;
	}
	
	//Constructor chaining
	public Box(double width, double height, double depth) {
		this(width, height);
		this.width = width;
		this.depth = depth;
		this.height = height;
	}
	
	public static int getCount()
	{
		return count;
	}

	public double getWidth() {
		return width;
	}

	public double getDepth() {
		return depth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public void setWidth(double width) {
		this.width = width;
	}
}
