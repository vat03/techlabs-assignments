package com.aurionpro.solution.test;

import com.aurionpro.solution.model.DBLogger;
import com.aurionpro.solution.model.FileLogger;
import com.aurionpro.solution.model.TaxCalculator;

public class TaxCalculatorTest {

	public static void main(String[] args) {
		
		TaxCalculator t1 = new TaxCalculator(new DBLogger());
		t1.CalculateTax(1000,0);
		
		TaxCalculator t2 = new TaxCalculator(new FileLogger());
		t2.CalculateTax(1000, 0);
	}

}
