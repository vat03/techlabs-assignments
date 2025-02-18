package com.aurionpro.AbstractFactory.test;

import com.aurionpro.AbstractFactory.model.ICar;
import com.aurionpro.AbstractFactory.model.ICarFactory;
import com.aurionpro.AbstractFactory.model.MahindraFactory;
import com.aurionpro.AbstractFactory.model.MarutiFactory;
import com.aurionpro.AbstractFactory.model.TataFactory;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		ICarFactory marutifactory = new MarutiFactory();
		ICarFactory mahindrafactory = new MahindraFactory();
		ICarFactory tatafactory = new TataFactory();
		
		ICar maruti = marutifactory.makeCar();
		ICar mahindra = mahindrafactory.makeCar();
		ICar tata = tatafactory.makeCar();
		
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
