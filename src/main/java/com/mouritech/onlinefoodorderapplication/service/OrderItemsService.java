package com.mouritech.onlinefoodorderapplication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.entity.OrderItem;

import com.mouritech.onlinefoodorderapplication.repository.OrderItemsRepository;

@Service
@Transactional
public class OrderItemsService {

	@Autowired
	OrderItemsRepository orderItemsRepository;

	public void addOrderedProducts(OrderItem orderItem) {
		orderItemsRepository.save(orderItem);
	}
}
