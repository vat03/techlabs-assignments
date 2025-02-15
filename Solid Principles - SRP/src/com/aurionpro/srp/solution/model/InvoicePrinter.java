package com.aurionpro.srp.solution.model;

public class InvoicePrinter {

	Invoice invoice;

	public InvoicePrinter(Invoice invoice) {
		this.invoice = invoice;
	}

	public void printInvoice() {

		TaxCalculator taxcalculator = new TaxCalculator(invoice);

		double amount = invoice.getAmount();
		double tax = taxcalculator.calculateTax(invoice.getAmount(), TaxCalculator.getTaxpercent());

		System.out.println("\nYour Invoice: ");
		System.out.println("Id: " + invoice.getId());
		System.out.println("Description: " + invoice.getDescription());
		System.out.println("Amount: " + amount);
		System.out.println("Tax: " + tax);
		System.out.println("Total Amount: " + (amount + tax));
	}
}
