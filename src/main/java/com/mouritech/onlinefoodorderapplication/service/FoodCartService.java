package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import com.mouritech.onlinefoodorderapplication.dto.AddToCartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.exceptions.CartItemNotExistException;

public interface FoodCartService {

	public void addFoodCart(List<AddToCartDto> dto1, Customer customer);

	public List<FoodCart> listFoodCarts(Customer customer);

	public CartDto listCartItems(Customer customer);

	public void updateCartItem(AddToCartDto cartDto, Customer customer, Items items);

	public void deleteCartItems(int customerId);

	public void deleteCartItem(long cartItemid, long userId) throws CartItemNotExistException;

	public void deleteUserCartItems(Customer customer);
}
