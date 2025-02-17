package com.aurionpro.singleton.test;

import com.aurionpro.singleton.model.DatabaseConnection;

public class SingletonTest {

	public static void main(String[] args) {
		DatabaseConnection databaseconnection1 = DatabaseConnection.getDatabaseConnection();
		System.out.println(databaseconnection1.hashCode());

		DatabaseConnection databaseconnection2 = DatabaseConnection.getDatabaseConnection();
		System.out.println(databaseconnection2.hashCode());
	}

}
