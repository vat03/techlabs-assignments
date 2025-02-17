package com.aurionpro.violation.test;

import com.aurionpro.violation.model.DBLogger;
import com.aurionpro.violation.model.TaxCalculator;

public class TaxCalculatorTest {
	public static void main(String[] args) {
		DBLogger dbLogger = new DBLogger();

		TaxCalculator t1 = new TaxCalculator(dbLogger);
		t1.CalculateTax(1000, 2);

		TaxCalculator t2 = new TaxCalculator(dbLogger);
		t2.CalculateTax(1000, 0);
	}
}
