package com.aurionpro.AbstractFactory.model;

public class MahindraFactory implements ICarFactory{

	@Override
	public ICar makeCar() {
		return new Mahindra();
	}

}
