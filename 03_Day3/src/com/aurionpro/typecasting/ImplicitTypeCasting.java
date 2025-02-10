package com.aurionpro.typecasting;

public class ImplicitTypeCasting {
	public static void main(String[] args) {
		byte number1 = 127;
		short number2 = number1;
		int number3 = number2;
		long number4 = number3;
		float number5 = number4;
		double number6 = number5;
		char ch = 'F';
		int asciivalue = ch;
		
		System.out.println("Byte: "+number1);
		System.out.println("Short: "+number2);
		System.out.println("Integer: "+number3);
		System.out.println("Long: "+number4);
		System.out.println("Float: "+number5);
		System.out.println("Double: "+number6);
		System.out.println("Character: "+ch);
		System.out.println("Asciivalue of ch: "+asciivalue);
	}
}
