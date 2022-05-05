package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;

public interface CustomerService {

	void addCustomerInformation(Customer customer);

	Customer findCustomerByEmailAndPassword(String customerEmail, String customerPassword);

	ResponseEntity<?> updatecustomerinfobyname(Customer customer);

	Customer deleteCustomer(Long customerId) throws ResourceNotFoundException;

	List<Customer> getAllCustomer();

	Customer addCustomer(Customer customer);
}