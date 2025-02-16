package com.aurionpro.Solution.model;

public class InterestCalculator {
	FixedDeposit fd;

	public InterestCalculator(FixedDeposit fd) {
		this.fd = fd;
	}

	public double calculateInterest() {
		double interestRate = fd.getFestivalinterest().getInterestRate();
		return fd.getPrinciple() * fd.getDuration() * (interestRate / 100);
	}
}