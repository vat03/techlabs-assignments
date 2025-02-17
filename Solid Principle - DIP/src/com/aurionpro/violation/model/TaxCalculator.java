package com.aurionpro.violation.model;

public class TaxCalculator {
	 DBLogger dblogger;
	
	public TaxCalculator(DBLogger dblogger) {
		this.dblogger = dblogger;
	}
	
	public int CalculateTax(int amount, int rate)
	{
		int tax = 0;
		try {
			tax = amount / rate; 
			System.out.println(tax);
		} catch (Exception e) {
			dblogger.log("Divide by zero");
		}
		return tax;
	}
}
