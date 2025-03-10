package com.aurionpro.test;

import com.aurionpro.model.StringList;
import java.util.ArrayList;
import java.util.Scanner;

public class StringListTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringList list = new StringList();

		while (true) {
			System.out.println("\n1.Add new String\n2. Display with Duplicates\n3. Remove Duplicates\n4. Exit");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				System.out.print("Enter the string: ");
				list.addString(scanner.nextLine());
				break;
			case 2:
				for (String string : list.getList()) {
					System.out.println(string);
				}
				break;
			case 3:
				ArrayList<String> uniqueList = list.removeDuplicates();
				System.out.println("\nList after removing duplicates:");
				for (String string : uniqueList) {
					System.out.println(string);
				}
				break;
			case 4:
				System.out.println("Exiting the application.");
				scanner.close();
				return;
			default:
				System.out.println("Enter a valid choice.");

			}
		}
	}
}
