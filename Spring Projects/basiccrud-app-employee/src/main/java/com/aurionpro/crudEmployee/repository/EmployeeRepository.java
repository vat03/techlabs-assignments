package com.aurionpro.crudEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.crudEmployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
