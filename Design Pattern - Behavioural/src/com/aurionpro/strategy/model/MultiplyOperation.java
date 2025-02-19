package com.aurionpro.strategy.model;

public class MultiplyOperation implements IOperation {

	@Override
	public int doOperation(int a, int b) {
		return (a * b);
	}

}
