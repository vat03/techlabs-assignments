package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameStreamTest {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh");
		System.out.println("Original list: ");
		names.stream().forEach((name) -> System.out.println(name));
		
		// Ascending first 3
		List<String> ascendingList = names.stream()
				.sorted()
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println("\nList of first 3 students sorted in ascending order: ");
		
		ascendingList.stream()
			.forEach((name) -> System.out.println(name));
		
		// Ascending first 3 with a
		List<String> ascendingListWithA = names.stream()
				.sorted()
				.filter((name) -> name.contains("a"))
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println("\nList of first 3 students sorted in ascending order if it contains 'A': ");
		
		ascendingListWithA.stream()
			.forEach((name) -> System.out.println(name));
		
		// Descending order
		List<String> descendingList = names.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		System.out.println("\nList of students sorted in descending order: ");
		
		descendingList.stream()
			.forEach((name) -> System.out.println(name));
		
		// First three characters of all the names
		System.out.println("\nList of students with first 3 letters only: ");
		
		names.stream()
			.forEach((name) -> System.out.println(name.substring(0, 3)));
		
		// Less than or equal to 4 letters
		List<String> lessThan4Letters = names.stream()
				.filter((name) -> (name.length() <= 4))
				.collect(Collectors.toList());
		
		System.out.println("\nList of students with less than or equal to 4 letters: ");
		
		lessThan4Letters.stream()
			.forEach((name) -> System.out.println(name));
	}
}
