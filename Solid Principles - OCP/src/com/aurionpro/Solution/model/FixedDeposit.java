package com.aurionpro.Solution.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principle;
	private int duration;
	private FestivalInterest festivalinterest;
	
	public FixedDeposit() {
		
	}
	
	public FixedDeposit(int accountNumber, String name, double principle, int duration, FestivalInterest festivalinterest) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.principle = principle;
		this.duration = duration;
		this.festivalinterest = festivalinterest;
	}

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

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public FestivalInterest getFestivalinterest() {
		return festivalinterest;
	}

	public void setFestivalinterest(FestivalInterest festivalinterest) {
		this.festivalinterest = festivalinterest;
	}
	
	
}
