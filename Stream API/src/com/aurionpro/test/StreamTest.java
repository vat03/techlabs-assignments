package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Aadit");
		names.add("Mustafa");
		names.add("Vatsal");
		names.add("Akshat");

		// For each takes consumer as parameter
		names.stream().forEach((name) -> {
			name += " BE";
			System.out.println(name);
		});
		
		// Map takes function as parameter
		List<String> updatedList = names.stream().map((name) -> name+" BE").collect(Collectors.toList());
		
		updatedList.stream().forEach((name) -> System.out.println(name));
		
		List<Integer> numbers = Arrays.asList(10, 13, 54, -4, 18, 1000, 0, 3, 39);
		
		int sum = numbers.stream().reduce(0, (x,y) -> x+y);
		System.out.println("Sum of all numbers is: "+sum);
		
		int sumofOdd = numbers.stream().filter((number) -> number%2 != 0).reduce(0, (x,y) -> x+y);
		System.out.println("sum of odd numbers is: "+sumofOdd);
	}
}
