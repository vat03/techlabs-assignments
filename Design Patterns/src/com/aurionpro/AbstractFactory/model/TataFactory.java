package com.aurionpro.AbstractFactory.model;

public class TataFactory implements ICarFactory {

	@Override
	public ICar makeCar() {
		return new Tata();
	}

}
