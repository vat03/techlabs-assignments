package com.aurionpro.FileHandling;

import java.io.*;

public class FileWrite {
	public static void main(String[] args) {
		try {
			FileWriter file = new FileWriter(
					"D:\\Aurionpro_Vatsal_Training\\04_Day4\\src\\com\\aurionpro\\FileHandling\\text.txt");

			file.write("I was just written");
			file.close();
			System.out.println("File write successfull !!");

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("An error occured !! File Write Unsuccessfull");
		}
	}
}
