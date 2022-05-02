package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto1;
import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantvarificationDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurentDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Order;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;
import com.mouritech.onlinefoodorderapplication.exceptions.OrderNotFoundException;

public interface OrderService1 {

	 public void placeOrder(Customer customer, PlaceOrderDto1 dto1);
	 public List<Order> listOrders(Customer customer);
	 public Order getOrder(long orderId) throws OrderNotFoundException;

}
