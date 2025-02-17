package com.aurionpro.prototype.model;

public class Colour implements IPrototype {

	private String colourName;

	public Colour(String colourName) {
		this.colourName = colourName;
	}

	@Override
	public IPrototype getClone() {
		return new Colour(colourName);
	}

	public String getColourName() {
		return colourName;
	}

//	public void setColourName(String colourName) {
//		this.colourName = colourName;
//	}
}
