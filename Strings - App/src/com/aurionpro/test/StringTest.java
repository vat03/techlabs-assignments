package com.aurionpro.test;

public class StringTest {
	public static void main(String[] args) {

		// ------ String is immutable
		// ------ Creates new object each time rather than modifying the first object
		// ------ stored in string pool which is part of heap memory and referred through reference in stack

//		String string1 = "abcd";
//		String string2 = "abcd";
//
//		System.out.println(string1 == string2);

		
		// ------ StringBuilder is mutable
		// ------ Does modification in the existing object
		
		StringBuilder string = new StringBuilder();
		string.insert(0, "hello");
		System.out.println("Original String: "+string);
		string.replace(0, 1,"H");
		System.out.println("String with replacement: "+string);
		string.reverse();
		System.out.println("Reverse string: "+string);
		string.reverse();
		System.out.println("Substring: "+string.substring(1));
		System.out.println("Original String: "+string);
	}
}	
