package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

import com.aurionpro.model.CreditCardPayment;
import com.aurionpro.model.DebitCardPayment;
import com.aurionpro.model.Payment;
import com.aurionpro.model.UPIPayment;

public class PaymentTest {
	public static void main(String[] args) {
		menu();
	}

	static {
		System.out.println("Welcome to the Payment Portal !!");
	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		double billAmount = (double) random.nextInt(50000);

		System.out.println("Your bill amount is: " + billAmount);
		boolean paymentProcessed = false;

		while (!paymentProcessed) {
			System.out.println("Select the payment option you would like to pay with: ");
			System.out.println("\n1. Credit Card Payment\n2. Debit Card Payment\n3. UPI Payment\n");
			int choice = scanner.nextInt();

			Payment payment = null;

			switch (choice) {
			case 1:
				payment = new CreditCardPayment();
				break;
			case 2:
				payment = new DebitCardPayment();
				break;
			case 3:
				payment = new UPIPayment();
				break;
			default:
				System.out.println("Enter a valid option !!");
				continue;
			}

			payment.processPayment(billAmount);
			paymentProcessed = true;
		}

		scanner.close();
	}
}
