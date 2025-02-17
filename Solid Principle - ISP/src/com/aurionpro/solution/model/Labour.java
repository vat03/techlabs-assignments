package com.aurionpro.solution.model;

public class Labour implements IWorker, IHumanWorker{

	@Override
	public void eat() {
		System.out.println("Labour is eating.");
	}

	@Override
	public void drink() {
		System.out.println("Labour is drinking.");
	}

	@Override
	public void startWork() {
		System.out.println("Labour started working.");
	}

	@Override
	public void stopWork() {
		System.out.println("Labour stopped working.");
	}

}
