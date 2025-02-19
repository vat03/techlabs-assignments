package com.aurionpro.iterator.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.iterator.model.Employee;
import com.aurionpro.iterator.model.EmployeeRepository;
import com.aurionpro.iterator.model.IIterator;

public class IteratorTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();

		employees.add(new Employee(1, "Emp-1", 15000));
		employees.add(new Employee(2, "Emp-2", 30000));
		employees.add(new Employee(3, "Emp-3", 25000));

		EmployeeRepository repository = new EmployeeRepository(employees);

		System.out.println("List of names of all the employees are: ");
		IIterator nameIterator = repository.getNameIterator();
		while (nameIterator.hasNext()) {
			System.out.println(nameIterator.next());
		}

		System.out.println();

		System.out.println("List of salary of all the employees are: ");
		IIterator salaryIterator = repository.getSalaryIterator();
		while (salaryIterator.hasNext()) {
			System.out.println(salaryIterator.next());
		}
	}
}
