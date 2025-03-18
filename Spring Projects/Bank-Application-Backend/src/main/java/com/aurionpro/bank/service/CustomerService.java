package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Customer;

public interface CustomerService {
	PageResponse<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize);

	CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

	void deleteCustomer(Customer customer);

	void deleteAllCustomers();
}
