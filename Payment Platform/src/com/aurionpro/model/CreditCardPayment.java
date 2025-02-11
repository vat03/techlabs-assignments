package com.aurionpro.model;

public class CreditCardPayment implements Payment {

    private final double creditLimit = 25000;
    private double amountRemaining = 18000;

    @Override
    public void processPayment(double amount) {
        if (amount > amountRemaining && amount < creditLimit) {
            System.out.println("Limit Crossed! Sorry, we cannot process this payment.");
        } else if (amount > creditLimit) {
            System.out.println("Your Credit Limit is " + creditLimit + ". Cannot process this payment.");
        } else {
            amountRemaining -= amount;
            System.out.println("Payment successful!!");
        }
    }
}
