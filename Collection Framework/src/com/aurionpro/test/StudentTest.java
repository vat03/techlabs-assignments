package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.AgeComparator;
import com.aurionpro.comparator.NameComparator;
import com.aurionpro.comparator.RollNumberComparator;
import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		
		List<Student> student = new ArrayList<Student>();

		getInput(student);
		
		System.out.println("Without sorted: ");
		displayStudents(student);
		
		System.out.println("Sorted according to Roll Number: ");
		Collections.sort(student, new RollNumberComparator());
		displayStudents(student);
	
		System.out.println("Sorted according to Age: ");
		Collections.sort(student, new AgeComparator());
		displayStudents(student);
	
		System.out.println("Sorted according to Name: ");
		Collections.sort(student, new NameComparator());
		displayStudents(student);
	}
	
	public static void getInput(List<Student> student)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of students: ");
		int numberOfStudents = scanner.nextInt();

		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println("Enter your roll number: ");
			int rollNumber = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter your name: ");
			String name = scanner.nextLine();
			System.out.println("Enter your age: ");
			int age = scanner.nextInt();

			student.add(new Student(rollNumber, name, age));
			
			scanner.close();
		}
	}
	
	public static void displayStudents(List<Student> student)
	{
		for (int i = 0; i < student.size(); i++) {
			System.out.println(student.get(i).getRollNumber()+"    "+student.get(i).getName()+"      "+student.get(i).getAge());
		}
	}
}
