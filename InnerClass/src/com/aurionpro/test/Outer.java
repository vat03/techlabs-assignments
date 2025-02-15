package com.aurionpro.test;

public class Outer {
	private int a = 10;
	
	class Inner
	{
		int b = 20;
		public void display() {
			System.out.println(a);
		}
	}
}
