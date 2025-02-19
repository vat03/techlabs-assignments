package com.aurionpro.test;

import com.aurionpro.model.*;
import java.util.Scanner;

public class MovieController {
	private MovieManager manager;

	public MovieController() {
		manager = new MovieManager();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			displayMenu();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			System.out.println();

			switch (choice) {
			case 1:
				displayMovies();
				break;
			case 2:
				setMovieDetails(scanner);
				break;
			case 3:
				manager.clearMovies();
				System.out.println("All movies have been cleared from the list.");
				break;
			case 4:
				manager.deleteAllMovies();
				System.out.println("All movies have been deleted.");
				break;
			case 5:
				System.out.println("Thanks for using my application, Goodbye!");
				break;
			default:
				System.out.println("Enter a valid choice. Please try again.");
			}
		} while (choice != 5);

		scanner.close();
	}

	private void displayMenu() {
		System.out.println("\nSimpleMoviesApp Menu:");
		System.out.println("1. Display Movies");
		System.out.println("2. Add Movie");
		System.out.println("3. Clear All Movies from the List");
		System.out.println("4. Delete All Movies");
		System.out.println("5. Exit");
	}

	private void displayMovies() {
		if (manager.getMovies().isEmpty()) {
			System.out.println("No movies to display.");
			return;
		}
		System.out.println("Movies:");
		for (Movie movie : manager.getMovies()) {
			System.out.println(movie);
		}
	}

	private void setMovieDetails(Scanner scanner) {
		System.out.print("Enter movie name: ");
		String name = scanner.nextLine();
		System.out.print("Enter movie year: ");
		int year = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter movie genre: ");
		String genre = scanner.nextLine();
		Movie movie = new Movie(manager.getMovieId(), name, year, genre);
		manager.addMovie(movie);
		System.out.println("Movie added successfully.");
	}

	public static void main(String[] args) {
		MovieController moviecontroller = new MovieController();
		moviecontroller.start();
	}
}