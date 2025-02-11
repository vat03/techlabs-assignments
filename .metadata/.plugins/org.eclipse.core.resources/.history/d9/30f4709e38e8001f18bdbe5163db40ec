package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(50);
		numbers.add(30);
		numbers.add(10);
		
		System.out.println("\nDirectly using object: ");
		System.out.println(numbers);
		
		System.out.println("\nUsing simple for loop: ");
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		System.out.println("\nUsing for each loop: ");
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
		System.out.println("\nUsing Iterator: ");
		Iterator<Integer> numberIterator = numbers.iterator();
		while(numberIterator.hasNext())
		{
			System.out.println(numberIterator.next());
		}
		
		System.out.println("\nUsing List Iterator: ");
		ListIterator<Integer> numberListIterator = numbers.listIterator();
		while(numberListIterator.hasNext())
		{
			System.out.println(numberListIterator.next());
		}
	}
}
