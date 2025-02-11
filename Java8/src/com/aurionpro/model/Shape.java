package com.aurionpro.model;

public interface Shape {

	void area();
	
	static void display()
	{
		System.out.println("From static method display");
	}
	
	default void show()
	{
		System.out.println("From default method show");
	}
}
