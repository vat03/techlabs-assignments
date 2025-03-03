package com.aurionpro.FileHandling;

import java.util.Scanner;
import java.io.*;

public class FileCharacterWordLineCount
{
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the name of the file with correct extension: ");
		String fileName = scanner.nextLine();
		
		System.out.println();
		
		File file = new File(fileName);
		
		try {
			if (file.createNewFile()) {
				System.out.println("File created succesfully with name "+fileName);
			}
			else if(file.exists())
			{
				System.out.println("File already exists with name"+fileName);
			}
			else
			{
				System.out.println("File not created !!");
			}
		} catch (IOException e) {
			System.out.println("Invalid Directory!! File not created");
		}
		
		
		System.out.println();
		
		System.out.println("Enter the text you want to write in the file (wirte 'done' in new line to end):");
		FileWriter filewriter = new FileWriter(file);
		
		while(true)
		{
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("done"))
			{
				break;
			}
			filewriter.write(input+"\n");
		}
		filewriter.close();
		System.out.println("Content written successfully.");
		
		FileReader filereader = new FileReader(fileName);
		
		int charCount = 0, wordCount = 0, lineCount = 0;
		boolean trackingWord = false;
		
		int ch;
		
		while((ch = filereader.read()) != -1)
		{
			charCount++;
			
			if(ch == '\n')
			{
				lineCount++;
			}
			
			if(ch == ' ' || ch == '\n' || ch == '\t')
			{
				trackingWord = false;
			}
			else if(trackingWord == false)
			{
				wordCount++;
				trackingWord = true;
			}
		}
		
		filereader.close();
		
		System.out.println();
		
		System.out.println("Number of Characters: "+charCount);
		System.out.println("Number of Words: "+wordCount);
		System.out.println("Number of Lines: "+lineCount);
		
		scanner.close();
	}
}