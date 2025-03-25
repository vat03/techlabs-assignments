package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.dto.PageResponse;

public interface CustomerService {
	PageResponse<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize);

	//CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

	CustomerResponseDto updateCustomer(int customerId, CustomerRequestDto customerRequestDto);

	void deleteCustomer(int customerId);

	// void deleteAllCustomers();
}
