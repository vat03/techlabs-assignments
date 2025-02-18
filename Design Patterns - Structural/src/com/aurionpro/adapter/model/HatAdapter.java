package com.aurionpro.adapter.model;

public class HatAdapter implements IItem {

	private Hat hat;
	
	public HatAdapter(String longName, String shortName, double price, double tax) {
		hat = new Hat(longName, shortName, price, tax); 
	}

	@Override
	public String displayName() {
		String name = hat.getLongName() + "-" + hat.getLongName();
		return name;
	}

	@Override
	public double displayFinalPrice() {
		double taxValue = hat.getPrice() * (hat.getTax() / 100);
		double finalPrice = hat.getPrice() + taxValue;
		return finalPrice;
	}
	
}
