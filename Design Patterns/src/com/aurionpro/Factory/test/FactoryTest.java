package com.aurionpro.Factory.test;

import com.aurionpro.Factory.model.CarFactory;
import com.aurionpro.Factory.model.CarType;
import com.aurionpro.Factory.model.ICar;

public class FactoryTest {
	public static void main(String[] args) {
		CarFactory factory = new CarFactory();

		ICar maruti = factory.makeCars(CarType.Maruti);
		ICar mahindra = factory.makeCars(CarType.Mahindra);
		ICar tata = factory.makeCars(CarType.Tata);

		System.out.println("Maruti: ");
		maruti.start();
		maruti.stop();

		System.out.println();

		System.out.println("Tata: ");
		tata.start();
		tata.stop();

		System.out.println();

		System.out.println("Mahindra: ");
		mahindra.start();
		mahindra.stop();
	}
}
