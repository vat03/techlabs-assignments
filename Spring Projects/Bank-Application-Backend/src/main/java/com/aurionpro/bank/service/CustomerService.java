package com.aurionpro.bank.service;

import java.util.List;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.entity.Customer;

public interface CustomerService {
	List<CustomerResponseDto> getAllCustomers();

	CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);
	
	void deleteCustomer(Customer customer);
	
	void deleteAllCustomers();
}
