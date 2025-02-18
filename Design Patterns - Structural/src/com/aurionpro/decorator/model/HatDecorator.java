package com.aurionpro.decorator.model;

public abstract class HatDecorator implements IHat{
	IHat hat;

	public HatDecorator(IHat hat) {
		this.hat = hat;
	}
	
	public double getPrice()
	{
		return hat.getPrice();
	}

	public String getDescription()
	{
		return hat.getDescription();
	}
}
