package com.aurionpro.singleton.model;

public class DatabaseConnection {
	
	private static DatabaseConnection connector = null;
	
	private DatabaseConnection() {

	}
	
	public static DatabaseConnection getDatabaseConnection()
	{
		if(connector == null)
			connector = new DatabaseConnection();
		return connector;
	}
}
