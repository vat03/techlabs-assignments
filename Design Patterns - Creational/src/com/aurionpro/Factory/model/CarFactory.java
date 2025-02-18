package com.aurionpro.Factory.model;

public class CarFactory {
	public ICar makeCars(CarType car) {
		if(car == CarType.Maruti)
			return new Maruti();
		if(car == CarType.Mahindra)
			return new Mahindra();		
		return new Tata();
	}
}
