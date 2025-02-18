package com.aurionpro.decorator.model;

public class WheelAlgin extends CarServiceDecorator {

	public WheelAlgin(ICarService car) {
		super(car);
	}

	public double getCost() {
		return 1000 + super.getCost();
	}
}
