package com.aurionpro.decorator.model;

public class OilChange extends CarServiceDecorator {

	public OilChange(ICarService car) {
		super(car);
	}

	public double getCost() {
		return 500 + super.getCost();
	}

}
