package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.config.MessageStrings;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto;
import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto1;
import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.entity.AuthenticationToken;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.Order;
import com.mouritech.onlinefoodorderapplication.entity.OrderItem;
import com.mouritech.onlinefoodorderapplication.enums.ResponseStatus;

import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;
import com.mouritech.onlinefoodorderapplication.exceptions.OrderNotFoundException;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository1;
import com.mouritech.onlinefoodorderapplication.repository.OrderItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.OrderRepository;
import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;

import com.mouritech.onlinefoodorderapplication.service.CustomerService2;
import com.mouritech.onlinefoodorderapplication.service.OrderService1;
import com.mouritech.onlinefoodorderapplication.utils.Helper;

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

        //List<CartItemDto> cartItemDtoList = cartDto.getcartItems();

      
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        //newOrder.setSessionId(sessionId);
        newOrder.setCustomer(customer);
        newOrder.setTotalPrice(cartDto.getTotalCost());
        newOrder.setShippingAddress(dto1.getShippingAddress());
        orderRepository.save(newOrder);
       List<OrderItem>  orderItemList = new ArrayList<>();
        for (PlaceOrderDto cartItemDto : dto1.getPlaceOrderDto()) {
           
            OrderItem orderItem = new OrderItem();
            orderItem.setCreatedDate(new Date());
            orderItem.setPrice(cartItemDto.getItemPrice());
            //orderItem.setItems(cartItemDto.getItemName());
            orderItem.setQuantity(cartItemDto.getItemQuantity());
            orderItem.setItemName(cartItemDto.getItemName());
           // orderItem.setShippingAddress(cartItemDto.getShippingAddress());
            orderItem.setTotal(cartItemDto.getItemPrice() * cartItemDto.getItemQuantity());
            orderItem.setOrder(newOrder);
            orderItemList.add(orderItemsRepository.save(orderItem));
        }
         
        //
        cartService.deleteUserCartItems(customer);
    }
    @Override
    public List<Order> listOrders(Customer customer) {
        return orderRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
//        ByCustomerOrderByCreatedDateDesc
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