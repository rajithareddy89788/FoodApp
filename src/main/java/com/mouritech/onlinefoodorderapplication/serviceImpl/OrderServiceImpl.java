package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto;
import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto1;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.Order;
import com.mouritech.onlinefoodorderapplication.entity.OrderItem;

import com.mouritech.onlinefoodorderapplication.exceptions.OrderNotFoundException;
import com.mouritech.onlinefoodorderapplication.repository.OrderItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.OrderRepository;

import com.mouritech.onlinefoodorderapplication.service.OrderService1;

@Service
@Transactional
public class OrderServiceImpl implements OrderService1 {

	@Autowired
	private FoodCartServiceImpl cartService;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemsRepository orderItemsRepository;

	@Override
	public void placeOrder(Customer customer, PlaceOrderDto1 dto1) {

		CartDto cartDto = cartService.listCartItems(customer);

		Order newOrder = new Order();
		newOrder.setCreatedDate(new Date());

		newOrder.setCustomer(customer);
		newOrder.setTotalPrice(cartDto.getTotalCost());
		newOrder.setShippingAddress(dto1.getShippingAddress());

		newOrder.setPaymentMode(dto1.getPaymentMode());
		orderRepository.save(newOrder);
		List<OrderItem> orderItemList = new ArrayList<>();
		for (PlaceOrderDto cartItemDto : dto1.getPlaceOrderDto()) {

			OrderItem orderItem = new OrderItem();
			orderItem.setCreatedDate(new Date());
			orderItem.setPrice(cartItemDto.getItemPrice());

			orderItem.setQuantity(cartItemDto.getItemQuantity());
			orderItem.setItemName(cartItemDto.getItemName());

			orderItem.setTotal(cartItemDto.getItemPrice() * cartItemDto.getItemQuantity());
			orderItem.setOrder(newOrder);
			orderItemList.add(orderItemsRepository.save(orderItem));
		}

		cartService.deleteUserCartItems(customer);
	}

	@Override
	public List<Order> listOrders(Customer customer) {
		return orderRepository.findAllByCustomerOrderByCreatedDateDesc(customer);

	}

	@Override
	public Order getOrder(long orderId) throws OrderNotFoundException {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			return order.get();
		}
		throw new OrderNotFoundException("Order not found");
	}

}