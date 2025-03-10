package com.aurionpro.test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.aurionpro.model.Student;

public class SetTest {
	public static void main(String[] args) {
		Set<Student> student = new TreeSet<Student>();
		getInput(student);
		displayStudents(student);
	}
	
	public static void getInput(Set<Student> student)
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
		}
		scanner.close();
	}
	
	public static void displayStudents(Set<Student> student)
	{
		// for list
//		for (int i = 0; i < student.size(); i++) {
//			System.out.println(student.get(i).getRollNumber()+"    "+student.get(i).getName()+"      "+student.get(i).getAge());
//		}
		
		//for set
		for (Student studentdata : student) {
			System.out.println(studentdata.getRollNumber()+"   "+studentdata.getName()+"   "+studentdata.getAge());
		}
	}
}
