package com.aurionpro.test;

import com.aurionpro.exception.AgeNotValid;
import com.aurionpro.model.Voter;

public class VoterTest {

	public static void main(String[] args) {
		try {
			Voter voter1 = new Voter("Vatsal", "vatsal03", 19);
			System.out.println(voter1);
		} catch (AgeNotValid exception) {
			System.out.println(exception.getMessage());
		}
	}
}
