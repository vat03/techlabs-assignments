package com.aurionpro.Factory.model;

public class Tata implements ICar{
	@Override
	public void start() {
		System.out.println("Tata Starts.");

	}

	@Override
	public void stop() {
		System.out.println("Tata Stops.");

	}
}
