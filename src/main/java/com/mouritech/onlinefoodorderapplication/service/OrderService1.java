package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto1;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.Order;
import com.mouritech.onlinefoodorderapplication.exceptions.OrderNotFoundException;

public interface OrderService1 {

	public void placeOrder(Customer customer, PlaceOrderDto1 dto1);

	public List<Order> listOrders(Customer customer);

	public Order getOrder(long orderId) throws OrderNotFoundException;

}
