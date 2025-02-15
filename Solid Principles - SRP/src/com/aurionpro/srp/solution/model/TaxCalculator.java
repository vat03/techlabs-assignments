package com.aurionpro.srp.solution.model;

public class TaxCalculator {

	private double tax;
	private static final double taxPercent = 10;

	Invoice invoice;

	public TaxCalculator(Invoice invoice) {
		this.invoice = invoice;
	}

	public static double getTaxpercent() {
		return taxPercent;
	}

	public double calculateTax(double amount, double taxPercent) {
		tax = (invoice.getAmount() * taxPercent) / 100;
		return tax;
	}
}
