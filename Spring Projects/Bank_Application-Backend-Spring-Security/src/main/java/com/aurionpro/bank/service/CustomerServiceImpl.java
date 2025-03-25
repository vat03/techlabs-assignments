package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.repository.CustomerRepository;
import com.aurionpro.bank.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private UserRepository userRepo;

	private ModelMapper mapper;

	public CustomerServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all active customers with pagination
	@Override
	public PageResponse<CustomerResponseDto> getAllCustomers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Customer> customerPage = customerRepo.findByIsActive(true, pageable);

		List<Customer> dbCustomers = customerPage.getContent();
		List<CustomerResponseDto> customerDtos = new ArrayList<>();

		for (Customer customer : dbCustomers) {
			customerDtos.add(mapper.map(customer, CustomerResponseDto.class));
		}

		PageResponse<CustomerResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(customerDtos);
		pageResponse.setTotalPages(customerPage.getTotalPages());
		pageResponse.setPageSize(customerPage.getSize());
		pageResponse.setTotalElements(customerPage.getTotalElements());
		pageResponse.setLast(customerPage.isLast());

		return pageResponse;
	}

	// Add customer
//	@Override
//	public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
//		Optional<User> userOptional = userRepo.findById(customerRequestDto.getUserId());
//		if (userOptional.isEmpty()) {
//			throw new RuntimeException("User not found with ID: " + customerRequestDto.getUserId());
//		}
//
//		User user = userOptional.get();
//		Customer customer = new Customer();
//		customer.setFirstName(customerRequestDto.getFirstName());
//		customer.setLastName(customerRequestDto.getLastName());
//		customer.setUser(user);
//		customer.setActive(true);
//
//		Customer savedCustomer = customerRepo.save(customer);
//		return mapper.map(savedCustomer, CustomerResponseDto.class);
//	}

	// update customer
	@Override
	@Transactional
	public CustomerResponseDto updateCustomer(int customerId, CustomerRequestDto customerRequestDto) {
		Optional<Customer> customerOptional = customerRepo.findById(customerId);

		if (customerOptional.isEmpty()) {
			throw new RuntimeException("Customer not found with ID: " + customerId);
		}

		Customer customer = customerOptional.get();

		customer.setFirstName(customerRequestDto.getFirstName());
		customer.setLastName(customerRequestDto.getLastName());

		Customer updatedCustomer = customerRepo.save(customer);

		return mapper.map(updatedCustomer, CustomerResponseDto.class);
	}

	// Soft delete a customer
	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		Optional<Customer> customerOptional = customerRepo.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.setActive(false);

			User user = customer.getUser();
			if (user != null) {
				user.setActive(false);
				userRepo.save(user);
			}

			customerRepo.save(customer);
		} else {
			throw new RuntimeException("Customer not found with ID: " + customerId);
		}
	}
//	@Override
//	public void deleteAllCustomers() {
//		List<Customer> customers = customerRepo.findAll();
//		for (Customer customer : customers) {
//			customer.setActive(false);
//
//			User user = customer.getUser();
//			if (user != null) {
//				user.setActive(false);
//				userRepo.save(user);
//			}
//
//			customerRepo.save(customer);
//		}
//	}
}
