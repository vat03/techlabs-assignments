package com.aurionpro.FileHandling;

import java.io.*;

public class FileRead {
	public static void main(String[] args) throws IOException{
		try {
			FileReader file = new FileReader(
			"D:\\Aurionpro_Vatsal_Training\\04_Day4\\src\\com\\aurionpro\\FileHandling\\text.txt");
			
			try {
				int i;
				while((i = file.read()) != -1)
				{
					System.out.print((char)i);
				}
			} finally {
				file.close();
			}
			System.out.println("\n\nFile read sucessfully !!");
		} catch (FileNotFoundException e) {
			System.out.println("An error occured!! File not read.");
		}
	}
}
