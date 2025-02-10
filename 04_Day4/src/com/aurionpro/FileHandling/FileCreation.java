package com.aurionpro.FileHandling;

import java.io.File;
import java.io.IOException;

public class FileCreation {
	public static void main(String[] args){

		File file = new File(
				"D:\\Aurionpro_Vatsal_Training\\04_Day4\\src\\com\\aurionpro\\FileHandling\\text.txt");
		
		try {
			if (file.createNewFile()) {
				System.out.println("File created succesfully !!");
			}
			else if(file.exists())
			{
				System.out.println("File already exists !!");
			}
			else
			{
				System.out.println("File not created !!");
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Invalid Directory!! File not created");
		}
	}
}
