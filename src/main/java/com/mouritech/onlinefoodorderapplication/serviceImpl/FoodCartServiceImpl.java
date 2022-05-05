package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mouritech.onlinefoodorderapplication.dto.AddToCartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartItemDto;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;
import com.mouritech.onlinefoodorderapplication.entity.Items;

import com.mouritech.onlinefoodorderapplication.exceptions.CartItemNotExistException;

import com.mouritech.onlinefoodorderapplication.repository.FoodCartItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartRepository;
import com.mouritech.onlinefoodorderapplication.repository.ItemsRepository;

import com.mouritech.onlinefoodorderapplication.service.FoodCartService;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	private FoodCartRepository foodCartRepository;

	@Autowired
	private FoodCartItemsRepository foodCartItemsRepository;
	@Autowired
	private ItemsRepository itemsRepository;
	@Autowired
	private ItemServiceImpl itemService;

	@Override
	public void addFoodCart(List<AddToCartDto> dto1, Customer customer) {

		List<FoodCart> foodcartlist = foodCartRepository.findAllByCustomer(customer);
		Optional<FoodCart> foodCartOpt = foodcartlist.stream().filter(cart -> cart.isActive()).findFirst();
		FoodCart foodCart;
		if (foodCartOpt.isPresent()) {
			foodCart = foodCartOpt.get();
		} else {
			foodCart = new FoodCart();
		}
		foodCart.setCreatedDate(new Date());
		foodCart.setCustomer(customer);
		foodCart.setActive(dto1.get(0).isActive());

		foodCartRepository.save(foodCart);
		List<FoodCartItems> foodCartItemsList = new ArrayList<>();

		dto1.stream().forEach(x -> {
			FoodCartItems foodCartItems1 = foodCartItemsRepository
					.findByItems1AndCustomer(itemsRepository.findById(x.getItemId()).get(), customer);

			if (ObjectUtils.isEmpty(foodCartItems1)) {
				foodCartItems1 = new FoodCartItems();
			}

			foodCartItems1.setQuantity(x.getQuantity());

			List<Items> productList = new ArrayList<>();

			foodCartItems1.setItems1(itemService.getProductById(x.getItemId()));

			productList.add(itemService.getProductById(x.getItemId()));

			foodCartItems1.setFoodCart(foodCart);
			foodCartItems1.setCustomer(customer);

			foodCartItemsList.add(foodCartItemsRepository.save(foodCartItems1));
		});

	}

	@Override
	public List<FoodCart> listFoodCarts(Customer customer) {
		return foodCartRepository.findAllByCustomer(customer);

	}

	@Override
	public CartDto listCartItems(Customer customer) {
		List<FoodCartItems> cartList = foodCartItemsRepository.findAllByCustomer(customer);
		List<CartItemDto> cartItems = new ArrayList<>();

		cartList.stream().forEach(x -> {
			CartItemDto cartItemDto = getDtoFromCart(x);
			cartItems.add(cartItemDto);
		});

		double totalCost = 0;

		for (CartItemDto cartItemDto : cartItems) {

			totalCost += (cartItemDto.getItems().getItemPrice() * cartItemDto.getQuantity());
		}

		return new CartDto(cartItems, totalCost);
	}

	public static CartItemDto getDtoFromCart(FoodCartItems foodCartItems) {
		return new CartItemDto(foodCartItems);
	}

	@SuppressWarnings("deprecation")
	public void updateCartItem(AddToCartDto cartDto, Customer customer, Items items) {

		FoodCartItems cart = foodCartItemsRepository.getOne(cartDto.getId());
		cart.setQuantity(cartDto.getQuantity());

		foodCartRepository.save(cart);
	}

	@Override
	public void deleteUserCartItems(Customer customer) {
		foodCartRepository.deleteByCustomer(customer);
	}

	@Override
	public void deleteCartItem(long cartItemId, long userId) throws CartItemNotExistException {
		if (!foodCartItemsRepository.existsById(cartItemId))
			throw new CartItemNotExistException("Cart id is invalid : " + cartItemId);
		foodCartItemsRepository.deleteById(cartItemId);

	}

	@Override
	public void deleteCartItems(int customerId) {
		foodCartRepository.deleteAll();
	}

}
