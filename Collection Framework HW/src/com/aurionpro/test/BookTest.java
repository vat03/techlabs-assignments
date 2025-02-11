package com.aurionpro.test;

import com.aurionpro.model.Book;
import java.util.Scanner;
import java.util.TreeSet;

public class BookTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TreeSet<Book> books = new TreeSet<>();

		while (true) {
			System.out.println("\n1. Add Book\n2. Display Books\n3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter ISBN: ");
				String isbn = scanner.nextLine();
				System.out.print("Enter Title: ");
				String title = scanner.nextLine();
				System.out.print("Enter Author: ");
				String author = scanner.nextLine();
				books.add(new Book(isbn, title, author));
				System.out.println("Book added successfully.");
				break;
			case 2:
				if (books.isEmpty()) {
					System.out.println("No books in the collection.");
				} else {
					System.out.println("\nBooks in Sorted Order according to the title: ");
					for (Book book : books) {
						System.out.println(book);
					}
				}
				break;
			case 3:
				System.out.println("Exiting the application.");
				scanner.close();
				return;
			default:
				System.out.println("Enter a valid choice.");
			}
		}
	}
}
