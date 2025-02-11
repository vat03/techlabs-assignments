package com.aurionpro.model;

public class DebitCardPayment implements Payment {
    private double balance = 30000;

    @Override
    public void processPayment(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Cannot process payment.");
        } else {
            balance -= amount;
            System.out.println("Payment successful! Remaining balance: " + balance);
        }
    }
}
