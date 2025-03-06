package com.aurionpro.springcore.model;

public class Computer 
{
	public String name;
	public Harddisk harddisk;
	
	public Computer()
	{
		System.out.println("Inside computer default constructor");
	}
	
	public Computer(String name, Harddisk harddisk) {
		super();
		this.name = name;
		this.harddisk = harddisk;
		System.out.println("Inside computer parametrized constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Inside computer name setter");
	}

	public Harddisk getHarddisk() {
		return harddisk;
	}

	public void setHarddisk(Harddisk harddisk) {
		this.harddisk = harddisk;
		System.out.println("Inside computer harddisk setter");
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", harddisk=" + harddisk + "]";
	}
	
	
	
}