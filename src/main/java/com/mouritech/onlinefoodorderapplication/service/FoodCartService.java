package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.dto.AddToCartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantvarificationDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurentDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.exceptions.CartItemNotExistException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;

public interface FoodCartService {

	 public void addFoodCart(List<AddToCartDto> dto1,Customer customer);
	
	    public List<FoodCart> listFoodCarts(Customer customer) ;
	    public CartDto listCartItems(Customer customer);   
		public void updateCartItem(AddToCartDto cartDto, Customer customer,Items items);
		public void deleteCartItems(int customerId);
		public void deleteCartItem(long id, long userId) throws CartItemNotExistException;
		 public void deleteUserCartItems(Customer customer);
}
