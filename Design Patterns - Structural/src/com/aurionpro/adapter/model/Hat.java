package com.aurionpro.adapter.model;

public class Hat {

	private String longName;
	private String shortName;
	private double price;
	private double tax;

	public Hat(String longName, String shortName, double price, double tax) {
		this.longName = longName;
		this.shortName = shortName;
		this.price = price;
		this.tax = tax;
	}

	public String getLongName() {
		return longName;
	}

	public String getShortName() {
		return shortName;
	}

	public double getPrice() {
		return price;
	}

	public double getTax() {
		return tax;
	}

}
