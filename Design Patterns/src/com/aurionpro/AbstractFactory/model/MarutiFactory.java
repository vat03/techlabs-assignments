package com.aurionpro.AbstractFactory.model;

public class MarutiFactory implements ICarFactory {

	@Override
	public ICar makeCar() {
		return new Maruti();
	}
	
}
