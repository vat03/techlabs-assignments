package com.aurionpro.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionTest {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			Class stringClass = Class.forName("java.lang.String");
			
			System.out.println("Name: "+stringClass.getName());
			System.out.println("Simple name: "+stringClass.getSimpleName());
			
			System.out.println("\nVarious methods of "+stringClass.getSimpleName()+" are: \n");
			
			Method methods[] = stringClass.getMethods();
			
			for (Method method : methods) {
				System.out.println(method.getName()+"------>"+method.getParameterCount());
				Parameter parameters[] = method.getParameters();
				for (Parameter parameter : parameters) {
					System.out.println(parameter.getName()+"----->"+parameter.getType());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
