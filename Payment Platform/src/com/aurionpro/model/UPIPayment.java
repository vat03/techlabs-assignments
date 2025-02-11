package com.aurionpro.model;

public class UPIPayment implements Payment {
    private double upiBalance = 15000;

    @Override
    public void processPayment(double amount) {
        if (amount > upiBalance) {
            System.out.println("Insufficient UPI balance! Cannot process payment.");
        } else {
            upiBalance -= amount;
            System.out.println("Payment successful via UPI! Remaining balance: " + upiBalance);
        }
    }
}
