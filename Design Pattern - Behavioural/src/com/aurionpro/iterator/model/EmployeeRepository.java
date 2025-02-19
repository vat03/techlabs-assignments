package com.aurionpro.iterator.model;

import java.util.List;

public class EmployeeRepository implements IContainer {

	private List<Employee> employees;

	public EmployeeRepository(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public IIterator getNameIterator() {
		return new NameIterator();
	}

	@Override
	public IIterator getSalaryIterator() {
		return new SalaryIterator();
	}

	// private classes NameIterator
	private class NameIterator implements IIterator {

		int index;

		@Override
		public boolean hasNext() {
			if (index < employees.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return employees.get(index++).getName();
			}
			return null;
		}
	}

	// private classes SalaryIterator
	private class SalaryIterator implements IIterator {

		int index;

		@Override
		public boolean hasNext() {
			if (index < employees.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return employees.get(index++).getSalary();
			}
			return null;
		}
	}
}
