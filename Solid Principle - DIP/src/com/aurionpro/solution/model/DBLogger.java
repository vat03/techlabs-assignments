package com.aurionpro.solution.model;

public class DBLogger implements ILogger{

	@Override
	public void log(String err) {
		System.err.println("Logged to Database: "+err);
	}

}
