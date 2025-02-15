package com.aurionpro.srp.violation.test;

import java.util.Scanner;

import com.aurionpro.srp.violation.model.Invoice;

public class InvoiceTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Invoice invoice = new Invoice();

		invoice = takeInput(invoice, scanner);
		invoice.calculateTax(invoice.getAmount(), Invoice.taxPercent);
		invoice.printInvoice();
	}

	public static Invoice takeInput(Invoice invoice, Scanner scanner) {
		System.out.println("Enter product id: ");
		invoice.setId(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter product description: ");
		invoice.setDescription(scanner.nextLine());
		System.out.println("Enter Amount: ");
		invoice.setAmount(scanner.nextDouble());

		invoice = new Invoice(invoice.getId(), invoice.getDescription(), invoice.getAmount());
		return invoice;
	}
}
