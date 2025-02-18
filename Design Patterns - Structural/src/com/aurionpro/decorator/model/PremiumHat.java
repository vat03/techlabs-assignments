package com.aurionpro.decorator.model;

public class PremiumHat implements IHat{

	@Override
	public double getPrice() {
		return 300;
	}

	@Override
	public String getDescription() {
		return "Premium Hat";
	}

}
