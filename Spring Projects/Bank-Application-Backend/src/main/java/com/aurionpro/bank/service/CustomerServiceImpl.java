//package com.aurionpro.bank.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.aurionpro.bank.dto.CustomerRequestDto;
//import com.aurionpro.bank.dto.CustomerResponseDto;
//import com.aurionpro.bank.entity.Customer;
//import com.aurionpro.bank.repository.CustomerRepository;
//
//@Service
//public class CustomerServiceImpl implements CustomerService{
//
//	@Autowired
//	private CustomerRepository customerRepo;
//	
//	private ModelMapper mapper;
//	
//	private CustomerServiceImpl()
//	{
//		this.mapper = new ModelMapper();
//	}
//	
//	// get all customers
//	@Override
//	public List<CustomerResponseDto> getAllCustomers() {
//		List<Customer> customers = customerRepo.findAll();
//		List<CustomerResponseDto> customerDto = new ArrayList<>();
//		for (Customer customer : customers) {
//			customerDto.add(mapper.map(customer, CustomerResponseDto.class));
//		}
//		
//		return customerDto;
//	}
//
//	// add / update customers
//	@Override
//	public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
//		Customer dbCustomer = customerRepo.save(mapper.map(customerRequestDto, Customer.class));
//		return mapper.map(dbCustomer, CustomerResponseDto.class);
//	}
//
//	// delete a customer
//	@Override
//	public void deleteCustomer(Customer customer) {
//		customerRepo.delete(customer);
//	}
//
//	// delete all customers
//	@Override
//	public void deleteAllCustomers() {
//		customerRepo.deleteAll();
//	}
//}

package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Customer;
import com.aurionpro.bank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	private ModelMapper mapper;

	private CustomerServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all customers with pagination
	@Override
	public PageResponse<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Customer> customers = customerRepo.findAll(pageable);

		List<Customer> dbCustomers = customers.getContent();
		List<CustomerResponseDto> customerDtoList = new ArrayList<>();

		for (Customer customer : dbCustomers) {
			customerDtoList.add(mapper.map(customer, CustomerResponseDto.class));
		}

		return new PageResponse<>(customers.getTotalPages(), customers.getSize(), customers.getTotalElements(),
				customers.isLast(), customerDtoList);
	}

	// Add or update customer
	@Override
	public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
		Customer dbCustomer = customerRepo.save(mapper.map(customerRequestDto, Customer.class));
		return mapper.map(dbCustomer, CustomerResponseDto.class);
	}

	// Delete a customer
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
	}

	// Delete all customers
	@Override
	public void deleteAllCustomers() {
		customerRepo.deleteAll();
	}
}
