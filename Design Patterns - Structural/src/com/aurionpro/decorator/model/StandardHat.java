package com.aurionpro.decorator.model;

public class StandardHat implements IHat{

	@Override
	public double getPrice() {
		return 100;
	}

	@Override
	public String getDescription() {
		return "Standard Hat";
	}

}
