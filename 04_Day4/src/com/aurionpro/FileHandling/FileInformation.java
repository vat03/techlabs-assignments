package com.aurionpro.FileHandling;

import java.io.File;

public class FileInformation {
	public static void main(String[] args) {

		File file = new File(
				"D:\\Aurionpro_Vatsal_Training\\04_Day4\\src\\com\\aurionpro\\FileHandling\\text.txt");
		
		if(file.exists())
		{
			System.out.println("File name: "+file.getName());
			System.out.println("Can read: "+file.canRead());
			System.out.println("Can write: "+file.canWrite());
			System.out.println("Can Execute: "+file.canExecute());
			System.out.println("Exists: "+file.exists());
			System.out.println("File path: "+file.getPath());
			System.out.println("Absolute path: "+file.getAbsolutePath());
		}
		else
		{
			System.out.println("File not exists");
		}

	}
}
