package com.aurionpro.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.aurionpro.model.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		System.out.print("Enter number of customers: ");
		int numberOfCustomers = scanner.nextInt();
		
		Customer[] customers = new Customer[numberOfCustomers];
		
		//for input
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
			takeInput(customers[i], scanner);
			System.out.println();
		}
		
		System.err.println();
		
		//for output
		System.out.println("Unsorted Output: \n");
		for (Customer customer : customers) {
			displayDetails(customer);
		}
		
		sort(customers);
		
		System.out.println();
		
		System.out.println("Sorted output: ");
		for (Customer customer : customers) {
			displayDetails(customer);
		}
		
		scanner.close();
	}
	
	public static void takeInput(Customer customer, Scanner scanner)
	{
		System.out.print("Enter your name: ");
		scanner.nextLine()
;		customer.setName(scanner.nextLine());
		System.out.print("Enter your email: ");
		customer.setEmail(scanner.nextLine());
		System.out.print("Enter you Date of Birth: ");
		String date = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateOfBirth = LocalDate.parse(date, formatter);
		customer.setDateOfBirth(dateOfBirth);
		System.out.print("Enter your Phone number: ");
		customer.setPhoneNumber(scanner.nextLine());
	}
	
	public static void displayDetails(Customer customer) {
		System.out.println("Customer Id: "+Customer.getCustomerId());
		System.out.println("Name: "+customer.getName());
		System.out.println("Email: "+customer.getEmail());
		System.out.println("Date of Birth: "+customer.getDateOfBirth());
		System.out.println("Phone number: "+customer.getPhoneNumber());
		System.out.println();
	}
	
	public static void sort(Customer[] customers) {
		for(int i = 0; i < customers.length - 1; i++)
		{
			for (int j = 0; j < customers.length - i - 1; j++) {
				if(customers[j].getDateOfBirth().getYear() > customers[j+1].getDateOfBirth().getYear())
				{
					swap(customers, j);
				}
				else if(customers[j].getDateOfBirth().getYear() == customers[j+1].getDateOfBirth().getYear())
				{
					if(customers[j].getDateOfBirth().getMonthValue() > customers[j+1].getDateOfBirth().getMonthValue())
					{
						swap(customers, j);
					}
					else if(customers[j].getDateOfBirth().getMonthValue() == customers[j+1].getDateOfBirth().getMonthValue())
					{
						if(customers[j].getDateOfBirth().getDayOfMonth() > customers[j+1].getDateOfBirth().getDayOfMonth())
						{
							swap(customers, j);
						}
					}
				}
			}
		}
	}
	
	public static void swap(Customer[] customers, int index)
	{
		Customer temp = customers[index];
		customers[index] = customers[index+1];
		customers[index+1] = temp;
	}
}
