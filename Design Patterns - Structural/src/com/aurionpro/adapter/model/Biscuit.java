package com.aurionpro.adapter.model;

public class Biscuit implements IItem{
	String name;
	double mrp;

	public Biscuit(String name, double mrp) {
		this.name = name;
		this.mrp = mrp;
	}

	@Override
	public String displayName() {
		return name;
	}

	@Override
	public double displayFinalPrice() {
		return mrp;
	}

}
