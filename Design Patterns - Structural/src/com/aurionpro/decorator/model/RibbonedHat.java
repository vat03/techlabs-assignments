package com.aurionpro.decorator.model;

public class RibbonedHat extends HatDecorator {

	public RibbonedHat(IHat hat) {
		super(hat);
	}

	public double getPrice() {
		return 70 + super.getPrice();
	}

	public String getDescription() {
		return "Ribboned - " + super.getDescription();
	}
}
