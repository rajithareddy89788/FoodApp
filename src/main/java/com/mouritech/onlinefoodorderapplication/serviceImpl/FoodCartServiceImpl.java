package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mouritech.onlinefoodorderapplication.config.MessageStrings;
import com.mouritech.onlinefoodorderapplication.dto.AddToCartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartItemDto;
import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.entity.AuthenticationToken;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;
import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.enums.ResponseStatus;

import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CartItemNotExistException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;

import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository1;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartRepository;
import com.mouritech.onlinefoodorderapplication.repository.ItemsRepository;
import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;

import com.mouritech.onlinefoodorderapplication.service.CustomerService2;
import com.mouritech.onlinefoodorderapplication.service.FoodCartItemsService;
import com.mouritech.onlinefoodorderapplication.service.FoodCartService;
import com.mouritech.onlinefoodorderapplication.utils.Helper;

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
	public void addFoodCart(List<AddToCartDto> dto1,Customer customer) {
		
	 	List<FoodCart> foodcartlist	=foodCartRepository.findAllByCustomer(customer);
	 	Optional<FoodCart> foodCartOpt = foodcartlist.stream().filter(cart ->  cart.isActive()).findFirst();
	 	FoodCart foodCart;
	 	if(foodCartOpt.isPresent()) {	
	 		foodCart = foodCartOpt.get();
	 	} else {
	 		foodCart = new FoodCart();
	 	}
		foodCart.setCreatedDate(new Date());
		foodCart.setCustomer(customer);
		foodCart.setActive(dto1.get(0).isActive());
		
		foodCartRepository.save(foodCart);
		List<FoodCartItems> foodCartItemsList = new ArrayList<>();
		 //List<Items> productList = new  ArrayList<>();
		
		
		for (AddToCartDto addToCartDto1 : dto1) {
			//List<FoodCart> foodcartlist1	=foodCartRepository.findAllByCustomer(customer);
			FoodCartItems foodCartItems1	= foodCartItemsRepository.findByCartItemId(addToCartDto1.getItemId());	
	if(ObjectUtils.isEmpty(foodCartItems1)) {	
		foodCartItems1 = new FoodCartItems();
 	} 
		
	
			//FoodCartItems foodCartItems1 = new FoodCartItems();
			foodCartItems1.setQuantity(addToCartDto1.getQuantity());
			//foodCartItems1.setActive(addToCartDto1.isActive());
			//foodCartItems1.setItemName(addToCartDto1.getItemName());
			//foodCartItems1.setItems1(items);
		 //productList.add(itemService.getProductById(addToCartDto1.getItemId()));
			List<Items> productList = new  ArrayList<>();
		      
		    	  //productList.add(itemService.getProductById(addToCartDto1.getItemId()));
		    	  foodCartItems1.setItems1 (itemService.getProductById(addToCartDto1.getItemId()));
		    	 
			       
		        //System.out.println("product to add"+  product.getName());
		    	  productList.add(itemService.getProductById(addToCartDto1.getItemId()));
		    
			//System.out.println("fdhgfjhgjh" + foodCartItems1.getItemName());
			foodCartItems1.setFoodCart(foodCart);
			foodCartItems1.setCustomer(customer);
			//foodCartItems1.setItemPrice(itemService.);
			foodCartItemsList.add(foodCartItemsRepository.save(foodCartItems1));
		}
	
		}
	

	@Override
	public List<FoodCart> listFoodCarts(Customer customer) {
		 return foodCartRepository.findAllByCustomer(customer);
      
   }
	@Override
	public CartDto listCartItems(Customer customer) {
		List<FoodCartItems> cartList = foodCartItemsRepository.findAllByCustomer(customer);
		List<CartItemDto> cartItems = new ArrayList<>();
		for (FoodCartItems cart : cartList) {
			CartItemDto cartItemDto = getDtoFromCart(cart);
			cartItems.add(cartItemDto);
		}
		double totalCost = 0;
		// String shippingAddress="";
//	       FoodCart dto=new FoodCart();
//		    String  shippingAddress=dto.getShippingAddress();
//		      System.out.println("##########"+shippingAddress);
		for (CartItemDto cartItemDto : cartItems) {

			totalCost += (cartItemDto.getItems().getItemPrice() * cartItemDto.getQuantity());
		}
		return new CartDto(cartItems, totalCost);
	}

	public static CartItemDto getDtoFromCart(FoodCartItems foodCartItems ) {
		return new CartItemDto(foodCartItems);
	}
	
	 @SuppressWarnings("deprecation")
		public void updateCartItem(AddToCartDto cartDto, Customer customer,Items items){
	    	
	        FoodCartItems cart = foodCartItemsRepository.getOne(cartDto.getId());
	        cart.setQuantity(cartDto.getQuantity());
	        //cart.setCreatedDate(new Date());
	        foodCartRepository.save(cart);
	  }
	 @Override
	 public void deleteUserCartItems(Customer customer) {
			foodCartRepository.deleteByCustomer(customer);
		}
	 @Override
	 public void deleteCartItem(long id, long userId) throws CartItemNotExistException {
			if (!foodCartRepository.existsById(id))
				throw new CartItemNotExistException("Cart id is invalid : " + id);
			foodCartRepository.deleteById(id);

		}
	 @Override
		public void deleteCartItems(int customerId) {
			foodCartRepository.deleteAll();
		}

		


	}
	 
