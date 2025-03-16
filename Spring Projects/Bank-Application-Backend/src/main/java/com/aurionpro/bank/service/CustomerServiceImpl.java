package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.entity.Customer;
import com.aurionpro.bank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	private ModelMapper mapper;
	
	private CustomerServiceImpl()
	{
		this.mapper = new ModelMapper();
	}
	
	// get all customers
	@Override
	public List<CustomerResponseDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		List<CustomerResponseDto> customerDto = new ArrayList<>();
		for (Customer customer : customers) {
			customerDto.add(mapper.map(customer, CustomerResponseDto.class));
		}
		
		return customerDto;
	}

	// add / update customers
	@Override
	public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
		Customer dbCustomer = customerRepo.save(mapper.map(customerRequestDto, Customer.class));
		return mapper.map(dbCustomer, CustomerResponseDto.class);
	}

	// delete a customer
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
	}

	// delete all customers
	@Override
	public void deleteAllCustomers() {
		customerRepo.deleteAll();
	}
}