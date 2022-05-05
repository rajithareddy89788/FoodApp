package com.mouritech.onlinefoodorderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mouritech.onlinefoodorderapplication.entity.Customer;

public interface CustomerRepository1 extends JpaRepository<Customer, Long> {

	Customer findByCustomerEmail(String customerEmail);

}
