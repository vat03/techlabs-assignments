package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.CustomerRequestDto;
import com.aurionpro.bank.dto.CustomerResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Customer;
import com.aurionpro.bank.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getAllCustomers")
	public ResponseEntity<PageResponse<CustomerResponseDto>> getAllCustomers(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(customerService.getAllCustomers(pageNumber, pageSize));
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerResponseDto> addCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		return ResponseEntity.ok(customerService.addCustomer(customerRequestDto));
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<CustomerResponseDto> updateCustomer(
			@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		return ResponseEntity.ok(customerService.addCustomer(customerRequestDto));
	}

	@DeleteMapping("/deleteCustomer")
	public void deleteCustomer(@RequestBody Customer customer) {
		customerService.deleteCustomer(customer);
	}

	@DeleteMapping("/deleteAllCustomers")
	public void deleteAllCustomers() {
		customerService.deleteAllCustomers();
	}
}
