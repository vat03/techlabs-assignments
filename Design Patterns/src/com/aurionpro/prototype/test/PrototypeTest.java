package com.aurionpro.prototype.test;

import com.aurionpro.prototype.model.Colour;

public class PrototypeTest {

	public static void main(String[] args) {
		Colour colour1 = new Colour("Red");
        Colour colour2 = (Colour) colour1.getClone();

        System.out.println("Original Colour: " + colour1.getColourName());
        System.out.println("Cloned Colour: " + colour2.getColourName());
	}
}
