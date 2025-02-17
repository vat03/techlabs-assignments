package com.aurionpro.solution.model;

public class FileLogger implements ILogger{

	@Override
	public void log(String err) {
		System.err.println("Logged to File: "+err);
	}

}
