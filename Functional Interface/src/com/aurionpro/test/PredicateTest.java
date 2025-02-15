package com.aurionpro.test;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Predicate<Integer> canVote = (age) ->
		{
			if(age >= 18)
				return true;
			return false;
		};
		
		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
		
		System.out.println("Can vote: "+canVote.test(age));
		
		scanner.close();
	}

}
