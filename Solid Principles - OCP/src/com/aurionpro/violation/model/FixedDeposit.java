package com.aurionpro.violation.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principle;
	private int duration;
	private FestivalType festival;

	public FixedDeposit() {

	}

	public FixedDeposit(int accountNumber, String name, double principle, int duration, FestivalType festival) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principle = principle;
		this.duration = duration;
		this.setFestival(festival);
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

	public FestivalType getFestival() {
		return festival;
	}

	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}

	private double getInterestRates() {
		if (festival.equals(FestivalType.NEWYEAR)) {
			return 8;
		}
		if (festival.equals(FestivalType.DIWALI)) {
			 return 8.5;
		}
		if (festival.equals(FestivalType.HOLI)) {
			return 7.5;
		}
		return 6.5;
	}

	public double calculateSimpleInterest() {
		return (principle * duration * getInterestRates()) / 100;
	}
}
