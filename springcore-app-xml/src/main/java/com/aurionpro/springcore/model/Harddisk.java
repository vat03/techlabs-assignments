package com.aurionpro.springcore.model;

public class Harddisk 
{
	private int capacity;
	
	public Harddisk() 
	{
		System.out.println("Inside harddisk default constructor");
	}

	public Harddisk(int capacity) {
		super();
		this.capacity = capacity;
		System.out.println("Inside harddisk parametrized constructor");
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
		System.out.println("Inside harddisk capacity setter");
	}

	@Override
	public String toString() {
		return "Harddisk [capacity=" + capacity + "]";
	}
	
}