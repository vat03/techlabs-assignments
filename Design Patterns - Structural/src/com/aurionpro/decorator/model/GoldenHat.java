package com.aurionpro.decorator.model;

public class GoldenHat extends HatDecorator {

	public GoldenHat(IHat hat) {
		super(hat);
	}

	public double getPrice() {
		return 100 + super.getPrice();
	}
	
	public String getDescription()
	{
		return "Golden - " + super.getDescription();
	}

}
