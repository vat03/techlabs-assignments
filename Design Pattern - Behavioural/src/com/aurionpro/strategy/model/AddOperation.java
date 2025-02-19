package com.aurionpro.strategy.model;

public class AddOperation implements IOperation {

	@Override
	public int doOperation(int a, int b) {

		return (a + b);
	}

}
