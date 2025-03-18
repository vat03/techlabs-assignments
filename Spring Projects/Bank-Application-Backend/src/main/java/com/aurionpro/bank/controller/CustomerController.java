package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Get all active customers with pagination
	@GetMapping("/getAllCustomers")
	public ResponseEntity<PageResponse<CustomerResponseDto>> getAllCustomers(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(customerService.getAllCustomers(pageNumber, pageSize));
	}

	// Add a new customer
//	@PostMapping("/addCustomer")
//	public ResponseEntity<CustomerResponseDto> addCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
//		return ResponseEntity.ok(customerService.addCustomer(customerRequestDto));
//	}

	// Update an existing customer
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable int customerId,
			@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		return ResponseEntity.ok(customerService.updateCustomer(customerId, customerRequestDto));
	}

	// Soft delete a customer by ID
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.ok("Customer with ID " + customerId + " has been deactivated successfully.");
	}

	// Soft delete all customers (if required)
//	@DeleteMapping("/deleteAllCustomers")
//	public ResponseEntity<String> deleteAllCustomers() {
//		customerService.deleteAllCustomers();
//		return ResponseEntity.ok("All customers have been deactivated successfully.");
//	}
}
