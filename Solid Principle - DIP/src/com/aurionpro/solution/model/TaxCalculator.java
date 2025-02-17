package com.aurionpro.solution.model;

public class TaxCalculator {
	
	ILogger logger;
	
	public TaxCalculator(ILogger logger) {
		this.logger = logger;
	}

	public int CalculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println(tax);
		} catch (Exception e) {
			logger.log("Divide by zero");
		}
		return tax;
	}
}
