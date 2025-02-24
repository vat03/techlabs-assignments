package com.aurionpro.test;

import com.aurionpro.model.DatabaseConnection;

public class ConnectionTest {

	public static void main(String[] args) {
		DatabaseConnection connection = new DatabaseConnection();

		connection.connect();
	}
}
