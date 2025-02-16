package com.aurionpro.Solution.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principle;
	private int duration;
	private FestivalInterest festivalinterest;

	// Default Constructor
	public FixedDeposit() {

	}

	// Parameterized Constructor
	public FixedDeposit(int accountNumber, String name, double principle, int duration,
			FestivalInterest festivalinterest) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.principle = principle;
		this.duration = duration;
		this.festivalinterest = festivalinterest;
	}

	// Getters
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getPrinciple() {
		return principle;
	}

	public int getDuration() {
		return duration;
	}

	public FestivalInterest getFestivalinterest() {
		return festivalinterest;
	}
}
