package com.aurionpro.typecasting;

public class WrapperClass {
	public static void main(String[] args) {
		// Autoboxing

		int number = 127;
		Integer obj = number;
		
		System.out.println(obj);
		
		//Unboxing
		int value = Integer.valueOf(obj);
		System.out.println(value);
		
		//parseInt
		int number1 = Integer.parseInt("500");
		System.out.println(number1);
		
		//Tostring
		String str = Integer.toString(number1);
		System.out.println(str);
		
		
		float float1 = 1.2f;
		String str1 = Float.toString(float1);
		System.out.println(str1);
		
		float float2 = 1.2f;
		String str2 = Float.toString(float2);
		System.out.println(str2);
		
		float sum = float1 + float2;
		System.out.println(sum);
		
		String strSum = str1 + str2;
		System.out.println(strSum);
	}
}
